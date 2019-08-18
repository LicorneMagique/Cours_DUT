start = () => {
	var counter = 0;
	var topscore = 1000000;
	var topscores = [];
	var historic = document.getElementById("won_topscores");
	
	if (window.location.hash == "" || window.location.hash == "#") {
		window.location.hash = "#1";
	}
	
	var html_links = document.getElementById("links");
	var p_txt = document.getElementById("txt");
	
	function removeAllChildren(node) {
		while (node.firstChild) {
			node.removeChild(node.firstChild);
		}
	}
	
	function capitalize(txt) {
		return txt.charAt(0).toUpperCase() + txt.slice(1);
	}
	
	function createLink(link, txt) {
		var txt = capitalize(txt.replace(/^Pour (.+), rendez vous au \d+$/, "$1"));
		
		var li = document.getElementById("link_template").cloneNode(true);
		li.style.display = "";
		li.children[0].href = link;
		li.children[0].innerText = txt;
		return li;
	}
	
	function unwon() {
		historic.innerText = "";
		document.getElementById("won_div").style.display = "none";
		document.getElementById("clicks").style.display = "";
	}
	
	function won() {
		if (counter < 10) {
			alert("Vous avez triché...");
			window.location.hash = "#1";
			return;
		}
		
		topscores[topscores.length] = counter;
		if (counter < topscore) {
			topscore = counter;
		}
		
		for (var i = 0; i < topscores.length; i++) {
			if (i == 0) {
				historic.innerText += topscores[i];
			} else {
				historic.innerText += ", " + topscores[i];
			}
		}
		document.getElementById("won_clicks").innerText = counter;
		document.getElementById("won_topscore").innerText = topscore;
		
		document.getElementById("won_div").style.display = "";
		document.getElementById("clicks").style.display = "none";
	}
	
	function hashchange() {
		var hash = parseInt(window.location.hash.substring(1), 10);
		document.getElementById("counter").innerText = counter;
		
		var url = "json/chapitre" + hash + ".json";
		var req = new XMLHttpRequest();
		req.open("GET", url, false);
		req.send();
		var chapter = JSON.parse(req.responseText);
		
		p_txt.innerText = chapter.txt;
		removeAllChildren(html_links);
		for (var i = 0; i < chapter.links.length; i++) {
			html_links.appendChild(
				createLink(chapter.links[i].link, chapter.links[i].txt)
			);
		}
		
		if (chapter.links.length == 0) {
			won();
		} else {
			unwon();
			if (hash == 1) {
				counter = 0;
				document.getElementById("clicks").style.display = "none";
			}
		}
		counter++;
	}
	
	document.getElementById("clicks").style.display = "none";
	window.addEventListener("hashchange", hashchange);
};

window.addEventListener("load", start);
