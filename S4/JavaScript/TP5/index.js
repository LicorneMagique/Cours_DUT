start = () => {
	var eraseAll = document.getElementById("eraseAll");
	var bucket = document.getElementById("bucket");
	var brushColor = document.getElementById("brushColor");
	brushColor.value = "#000000";
	var brushWidth = document.getElementById("brushWidth");
	brushWidth.value = "1";
	
	var canvas = document.getElementById("canvas");
	var rect = canvas.getBoundingClientRect();
	var top = rect.top;
	var left = rect.left;
	
	var ctx = canvas.getContext("2d");
	style = "rgb(0, 0, 0)"
	// ----------------------------
	ctx.strokeStyle = style;
	ctx.fillStyle = style;
	ctx.lineWidth = 1;
	// ----------------------------
	
	is_mouse_down = false;
	bucketMode = false;
	function mouseup(event) {
		if (is_mouse_down) {
			x = event.pageX - left;
			y = event.pageY - top;
			ctx.closePath();
			ctx.beginPath();
			ctx.arc(x, y, ctx.lineWidth/2, 0, 2 * Math.PI);
			ctx.fill();
			ctx.closePath();
		}
		is_mouse_down = false;
	}
	function mousedown(event) {
		x = event.pageX - left;
		y = event.pageY - top;
		if (bucketMode) {
			bucketFill(x, y);
		} else {
			is_mouse_down = true;
			ctx.beginPath();
			ctx.arc(x, y, ctx.lineWidth/2, 0, 2 * Math.PI);
			ctx.fill();
			ctx.closePath();
			ctx.beginPath();
			ctx.moveTo(x, y);
		}
	}
	function mousemove(event) {
		if (!is_mouse_down) return;
		x = event.pageX - left;
		y = event.pageY - top;
		ctx.lineTo(x, y);
		ctx.stroke();
	}
	
	var eraseSpeed = 3;
	function onclickEraseAll() {
		var x = 0;
		var eraseProgressive = function() {
			ctx.clearRect(x, 0, (x + eraseSpeed < canvas.width ? x + eraseSpeed : canvas.width - 1), canvas.height);
			x += eraseSpeed;
			if (x < canvas.width)
				setTimeout(eraseProgressive, 5);
		};
		eraseProgressive();
	}
	/*
	function onclickBucket() {
		bucketMode = !bucketMode;
	}
	
	function bucketFill(x, y) {
		var targetColor = getPixelsColor(x, y, 1, 1);
		_bucketFill(x, y, targetColor);
	}*/
	function oninputBrushColor(event) {
		var style = event.target.value;
		ctx.strokeStyle = style;
		ctx.fillStyle = style;
	}
	function oninputBrushWidth(event) {
		ctx.lineWidth = event.target.value;
	}
	function onresize() {
		rect = canvas.getBoundingClientRect();
		top = rect.top;
		left = rect.left;
	}
	
	eraseAll.addEventListener("click", onclickEraseAll);
	//bucket.addEventListener("click", onclickBucket);
	brushColor.addEventListener("input", oninputBrushColor);
	brushWidth.addEventListener("input", oninputBrushWidth);
	
	document.addEventListener("mouseup", mouseup);
	canvas.addEventListener("mousedown", mousedown);
	document.addEventListener("mousemove", mousemove);
	
	window.addEventListener("resize", onresize);
	/*
	function setPixelColor(x, y) {
		ctx.fillRect(x, y, 1, 1);
	}
	function getPixelsColor(x, y, width, height) {
		return ctx.getImageData(x, y, width, height).data;
	}
	function getPixelColor(pixels, x, y) {
		return [
			pixels[4*(x+y*800)+0],
			pixels[4*(x+y*800)+1],
			pixels[4*(x+y*800)+2],
			pixels[4*(x+y*800)+3]
		];
	}
	function setArrayPixelsValidated(pixels, x, y, targetColor) {
		pixels[4*(x+y*800)+0] = targetColor[0];
		pixels[4*(x+y*800)+1] = targetColor[1];
		pixels[4*(x+y*800)+2] = targetColor[2];
		pixels[4*(x+y*800)+3] = targetColor[3];
	}
	function compareColors(color1, color2) {
		return color1[0] == color2[0]
			&& color1[1] == color2[1]
			&& color1[2] == color2[2]
			&& color1[3] == color2[3];
	}
	function _bucketFill(x, y, targetColor) {
		var pixels = getPixelsColor(0, 0, canvas.width, canvas.height);
		var stack = [];
		stack.push([x, y]);
		while (true) {
			console.log(stack.length);
			var a = stack.pop();
			if (typeof(a) == "undefined") return;
			var x = a[0];
			var y = a[1];
			if (x+1 < canvas.width && compareColors(getPixelColor(pixels, x+1, y), targetColor)) {
				setArrayPixelsValidated(pixels, x+1, y, targetColor);
				setPixelColor(x+1, y);
				stack.push([x+1, y]);
			}
			if (y+1 < canvas.height && compareColors(getPixelColor(pixels, x, y+1), targetColor)) {
				setArrayPixelsValidated(pixels, x, y+1, targetColor);
				setPixelColor(x, y+1);
				stack.push([x, y+1]);
			}
			if (x-1 >= 0 && compareColors(getPixelColor(pixels, x-1, y), targetColor)) {
				setArrayPixelsValidated(pixels, x-1, y, targetColor);
				setPixelColor(x-1, y);
				stack.push([x-1, y]);
			}
			if (y-1 >= 0 && compareColors(getPixelColor(pixels, x, y-1), targetColor)) {
				setArrayPixelsValidated(pixels, x, y-1, targetColor);
				setPixelColor(x, y-1);
				stack.push([x, y-1]);
			}
		}
	}*/
};

window.addEventListener("load", start);
