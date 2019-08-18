start = () => {
	var levels = [
		{
			"dimensions": [30, 30],
			"delay": 200,
			"horizontal_walls": [
				[1, 1, 30], [1, 30, 30]
			],
			"vertical_walls": [
				[1, 1, 30], [30, 1, 30]
			],
			"dotwalls": [],
			"fruit": [10, 10]
		},
		{
			"dimensions": [30, 30],
			"delay": 100,
			"horizontal_walls": [
				[1, 1, 13], [18, 1, 30],
				[1, 30, 13], [18, 30, 30]
			],
			"vertical_walls": [
				[1, 1, 13], [1, 18, 30],
				[30, 1, 13], [30, 18, 30]
			],
			"dotwalls": [],
			"fruit": [10, 10]
		},
		{
			"dimensions": [30, 30],
			"delay": 70,
			"horizontal_walls": [
				[1, 1, 13], [18, 1, 30],
				[1, 30, 13], [18, 30, 30]
			],
			"vertical_walls": [
				[1, 1, 13], [1, 18, 30],
				[30, 1, 13], [30, 18, 30]
			],
			"dotwalls": [
				[10, 10], [20, 20], [10, 20], [20, 10]
			],
			"fruit": [9, 10]
		},
		{
			"dimensions": [30, 30],
			"delay": 50,
			"horizontal_walls": [
				[10, 20, 20]
			],
			"vertical_walls": [
				[20, 10, 20]
			],
			"dotwalls": [],
			"fruit": [9, 10]
		},
		{
			"dimensions": [80, 40],
			"delay": 30,
			"horizontal_walls": [],
			"vertical_walls": [],
			"dotwalls": [
				[8, 20], [12, 15], [17, 20], [15, 39],
				[47, 35], [70, 8], [78, 25], [72, 39]
			],
			"fruit": [9, 10]
		}
	];
	
	
	var VIDE = 0;
	var SERPENT = 1;
	var FRUIT = 2;
	var MUR = 3;
	var canvas = document.getElementById("canvas");
	var ctx = canvas.getContext("2d");
	var refresh_token;
	
	var is_in_game = false;
	var directions = [];
	var last_direction;
	var fruit;
	var score;
	
	var monde;
	var serpent = [];
	var delay;
	
	function generate_level(level) {
		canvas.width = level.dimensions[0]*20;
		canvas.height = level.dimensions[1]*20;
		var monde = Array(level.dimensions[0]).fill().map(() => Array(level.dimensions[1]).fill(VIDE));
		ctx.fillStyle = "rgb(160, 160, 160)";
		for (var i = 0; i < level.dotwalls.length; i++) {
			var x = level.dotwalls[i][0];
			var y = level.dotwalls[i][1]
			monde[x-1][y-1] = MUR;
			ctx.fillRect((x-1)*20+2, (y-1)*20+2, 16, 16);
		}
		for (var i = 0; i < level.horizontal_walls.length; i++) {
			var y = level.horizontal_walls[i][1];
			for (var x = level.horizontal_walls[i][0]; x <= level.horizontal_walls[i][2]; x++) {
				monde[x-1][y-1] = MUR;
				ctx.fillRect((x-1)*20+2, (y-1)*20+2, 16, 16);
			}
		}
		for (var i = 0; i < level.vertical_walls.length; i++) {
			var x = level.vertical_walls[i][0];
			for (var y = level.vertical_walls[i][1]; y <= level.vertical_walls[i][2]; y++) {
				monde[x-1][y-1] = MUR;
				ctx.fillRect((x-1)*20+2, (y-1)*20+2, 16, 16);
			}
		}
		
		ctx.fillStyle = "red";
		monde[level.fruit[0] - 1][level.fruit[1] - 1] = FRUIT;
		ctx.fillRect((level.fruit[0] - 1)*20+2, (level.fruit[1] - 1)*20+2, 16, 16);
		ctx.fillStyle = "darkgreen";
		var serpent = [];
		{
			var a = random_block_VIDE(monde);
			var x = a[0], y = a[1];
			monde[x][y] = SERPENT;
			serpent.push([x, y]);
			ctx.fillRect(x*20+2, y*20+2, 16, 16);
		}
		
		return [monde, serpent, level.delay];
	}
	
	function randomIntFromInterval(min, max) // [min; max[
	{
		return Math.floor(Math.random()*(max-min)+min);
	}
	function random_block_VIDE(monde) {
		while (true) {
			var x = randomIntFromInterval(0, monde.length);
			var y = randomIntFromInterval(0, monde[0].length);
			if (monde[x][y] == VIDE)
				return [x, y];
		}
	}
	function newFruit() {
		score += 1;
		var b = random_block_VIDE(monde);
		var x = b[0], y = b[1];
		monde[x][y] = FRUIT;
		ctx.fillStyle = "red";
		ctx.fillRect(x*20+2, y*20+2, 16, 16);
	}
	
	function getMousePos(event) {
		var rect = canvas.getBoundingClientRect();
		return {
			x: event.clientX - rect.left,
			y: event.clientY - rect.top
		};
	}
	
	function refresh() {
		if(movements() == false) {
			alert("You scored " + score + "!");
			menu();
		}
	}
	
	function movements() {
		if (last_direction == "none" && directions.length == 0) return;
		var curr_direction = "none";
		if (directions.length == 0) curr_direction = last_direction;
		else {
			curr_direction = directions.shift();
			var direction_invalid = true;
			while (true) {
				switch (curr_direction) {
				case "down":
					if (last_direction != "up") direction_invalid = false;
					break;
				case "up":
					if (last_direction != "down") direction_invalid = false;
					break;
				case "left":
					if (last_direction != "right") direction_invalid = false;
					break;
				case "right":
					if (last_direction != "left") direction_invalid = false;
					break;
				}
				if (!direction_invalid) break;
				curr_direction = directions.shift();
			}
		}
		var a = serpent[serpent.length - 1];
		var x = a[0];
		var y = a[1];
		if (fruit <= 0) {
			a = serpent.shift();
			last_x = a[0];
			last_y = a[1];
			monde[last_x][last_y] = VIDE;
			ctx.clearRect(last_x*20, last_y*20, 20, 20);
		} else {
			fruit--;
		}
		switch (curr_direction) {
		case "up":
			if (y+1 >= monde[0].length)
				y = -1;
			
			switch (monde[x][y+1]) {
			case SERPENT:
			case MUR:
				return false;
			case FRUIT:
				fruit += 4;
				newFruit();
				break;
			}
			serpent.push([x, y+1]);
			monde[x][y+1] = SERPENT;
			break;
		case "down":
			if (y-1 < 0)
				y = monde[0].length;
			
			switch (monde[x][y-1]) {
			case SERPENT:
			case MUR:
				return false;
			case FRUIT:
				fruit += 4;
				newFruit();
				break;
			}
			serpent.push([x, y-1]);
			monde[x][y-1] = SERPENT;
			break;
		case "right":
			if (x+1 >= monde.length)
				x = -1;
			
			switch (monde[x+1][y]) {
			case SERPENT:
			case MUR:
				return false;
			case FRUIT:
				fruit += 4;
				newFruit();
				break;
			}
			serpent.push([x+1, y]);
			monde[x+1][y] = SERPENT;
			break;
		case "left":
			if (x-1 < 0)
				x = monde.length;
			
			switch (monde[x-1][y]) {
			case SERPENT:
			case MUR:
				return false;
			case FRUIT:
				fruit += 4;
				newFruit();
				break;
			}
			serpent.push([x-1, y]);
			monde[x-1][y] = SERPENT;
			break;
		}
		ctx.fillStyle = "darkgreen";
		ctx.fillRect(serpent[serpent.length-1][0]*20+2, serpent[serpent.length-1][1]*20+2, 16, 16);
		last_direction = curr_direction;
		return true;
	}
	
	function onKeydown(event) {
		if (is_in_game) {
			if (event.keyCode == 27) {
				menu();
			}
			if (directions.length != 0) {
				switch (event.keyCode) {
				case 37:
					if (directions[directions.length-1] != "left" && directions[directions.length-1] != "right")
						directions.push("left");
					break;
				case 38:
					if (directions[directions.length-1] != "down" && directions[directions.length-1] != "up")
						directions.push("down");
					break;
				case 39:
					if (directions[directions.length-1] != "right" && directions[directions.length-1] != "left")
						directions.push("right");
					break;
				case 40:
					if (directions[directions.length-1] != "up" && directions[directions.length-1] != "down")
						directions.push("up");
					break;
				default:
					break;
				}
			} else {
				switch (event.keyCode) {
				case 37:
					if (last_direction != "left" && last_direction != "right")
						directions.push("left");
					break;
				case 38:
					if (last_direction != "down" && last_direction != "up")
						directions.push("down");
					break;
				case 39:
					if (last_direction != "left" && last_direction != "right")
						directions.push("right");
					break;
				case 40:
					if (last_direction != "down" && last_direction != "up")
						directions.push("up");
					break;
				default:
					break;
				}
			}
		}
	}
	
	function onMousedown(event) {
		var x = 75;
		var y = 40;
		var wx = 132;
		var wy = 62;
		if (!is_in_game) {
			var mousePos = getMousePos(event);
			var chosen = -1;
			for (var i = 0; i < 6; i++) {
				if (mousePos.x > x && mousePos.x < wx && mousePos.y > y && mousePos.y < wy) {
					chosen = i;
					break;
				}
				x += 120;
				wx += 120;
			}
			if (chosen == -1)
				return;
			if (chosen >= levels.length) {
				alert("Le niveau choisi n'a pas encore été ajouté jeune impatient");
				return;
			}
			directions = [];
			last_direction = "none";
			fruit = 0;
			score = 0;
				
			var a = generate_level(levels[chosen]);
			monde = a[0];
			serpent = a[1];
			delay = a[2];
				
			is_in_game = true;
			refresh_token = setInterval(refresh, delay);
		}
	}
	
	function menu() {
		clearInterval(refresh_token);
		is_in_game = false;
		
		ctx.clearRect(0, 0, canvas.width, canvas.height);
		canvas.width = 800;
		canvas.height = 800;
		
		ctx.fillStyle = "black";
		ctx.font = "22px Arial";
		ctx.fillText("Lvl 1", 80, 60);
		ctx.fillText("Lvl 2", 20+60*3, 60);
		ctx.fillText("Lvl 3", 20+60*5, 60);
		ctx.fillText("Lvl 4", 20+60*7, 60);
		ctx.fillText("Lvl 5", 20+60*9, 60);
		ctx.fillText("Lvl 6", 20+60*11, 60);
	}
	
	document.body.addEventListener("keydown", onKeydown);
	document.body.addEventListener("mousedown", onMousedown);
	menu();
};

window.addEventListener("load", start);
