start = () => {

    // Code qui ne sera exécuté qu'une seule fois
    sounds = [
		"https://vocaroo.com/media_command.php?media=s1Oz5r3nbeRA&command=download_mp3",
		"https://vocaroo.com/media_command.php?media=s0UnpAVihMnm&command=download_mp3",
		"https://vocaroo.com/media_command.php?media=s0YFIuYnZ3Zb&command=download_mp3"
	]
	alarms = {};
	length = 0;
    should_fire = true;
	document.getElementById("add_alarm").addEventListener("click", addAlarm);
    document.getElementById("add_alarm").click();
    
    // Lance un thread qui se ré exécutera toutes les secondes
    update();

};

window.addEventListener("load", start);

function update() {
    
    // Liste des fonctions à appeler à chaque update
    updateAlarme();
    updateHorloge();

    // Ré-appel de la fonction update
    setTimeout(function() {
        update();
    }, 1000 - new Date().getMilliseconds());
    
}

function addAlarm(event) {
    event.preventDefault();
    var new_alarm = document.getElementById("alarm_template").cloneNode(true);
    new_alarm.id = length;
    length++;
    new_alarm.style.display = "block";
    alarms[new_alarm.id] = {
        id: new_alarm.id,
        activated: false,
        heure: 0,
        minute: 0,
        nom: "",
        son: 1
    };
    new_alarm.addEventListener("input", modifieAlarme);
    new_alarm.addEventListener("submit", supprimeAlarme);
    document.body.insertBefore(new_alarm, document.getElementById("alarm_template"));
}

function supprimeAlarme(event) {
    event.preventDefault();
    delete alarms[event.target.id];
    var audio = document.getElementById("audio_"+event.target.id);
    if(audio != null)
        audio.parentNode.removeChild(audio);
    else if(confirm("Êtes-vous sûr·e de vouloir supprimer cette alarme ?"))
        event.target.parentNode.removeChild(event.target);
}

function updateHorloge() { // Met à jour l'heure affichée

    // Récupération de la date
    var date = new Date();

    // Valeurs numériques de l'heure
    var heure = date.getHours();
    var minute = date.getMinutes();
    var seconde = date.getSeconds();

    // Valeurs à afficher (de type String)
    var theure = heure < 10 ? "0" + heure : heure;
    var tminute = minute < 10 ? "0" + minute : minute;
    var tseconde = seconde < 10 ? "0" + seconde : seconde;

    // Écriture de l'heure sur la page
    document.querySelector("nav#heure").innerText = theure;
    document.querySelector("nav#minute").innerText = tminute;
    document.querySelector("nav#seconde").innerText = tseconde;
}

function updateAlarme() {
    var date = new Date();
    var heure = date.getHours();
    var minute = date.getMinutes();
    var seconde = date.getSeconds();

    if(seconde == 0 && should_fire) {
        should_fire = false;
        Object.values(alarms).forEach(function(x) {
            if(x.activated && x.heure == heure && x.minute == minute)
                ring(x);
        });
    } else if(seconde != 0) {
        should_fire = true;
    }
}

function ring(alarm) {
    var new_audio = document.getElementById("audio_template").cloneNode(true);
    new_audio.id = "audio_"+alarm.id;
    new_audio.autoplay = true;
    new_audio.children[0].src = sounds[alarm.son];
    document.body.appendChild(new_audio);
    setTimeout(function() {
        new_audio.parentNode.removeChild(new_audio);
    }, 300000); // 5 minutes
}

function modifieAlarme(event) {
    // Récupération des valeurs
    var form = event.target.parentNode;
    var activated = form.querySelector("[name=\"activated\"]").checked;
    var heure = form.querySelector("[name=\"heure\"]").value;
    var minute = form.querySelector("[name=\"minute\"]").value;
    var nom = form.querySelector("[name=\"nom\"]").value;
    var son = form.querySelector("[name=\"son\"]").value;

    // Mises à jour des valeurs
    if (heure == 24) {
        heure = 0;
        form.querySelector("[name=\"heure\"]").value = 0;
    }
    else if (heure == -1) {
        heure = 23;
        form.querySelector("[name=\"heure\"]").value = 23;
    }
    if (minute == 60) {
        minute = 0;
        form.querySelector("[name=\"minute\"]").value = 0;
    }
    else if (minute == -1) {
        minute = 59;
        form.querySelector("[name=\"minute\"]").value = 59;
    }

    // Mises à jour des valeurs sur la page
    alarms[form.id] = {
        id: form.id,
        activated: activated,
        heure: heure,
        minute: minute,
        nom: nom,
        son: son
    };
}
