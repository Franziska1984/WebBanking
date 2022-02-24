
document.getElementById("btn2").addEventListener("click", testDataStart);
document.getElementById("btn3").addEventListener("click", auslesen);

function testDataStart() {
    var eingabeUser = document.getElementById("input2").value;
    var url = "/testdaten/" + eingabeUser
    window.location = url;
}

function empfaenger1(antwort) {
	var json = antwort.json();
	return json;
}

function empfaenger2(json) {
	var empfaenger = json.empfaenger;
	var iban = json.iban;
	var bic = json.bic;
	var betrag = json.betrag;
	var waehrung = json.waehrung;
	var verwendungszweck = json.verwendungszweck;

	//Ausgabe Bankdaten
	//document.getElementById("Output").innerHTML;
	document.getElementById("empfaenger").innerHTML = empfaenger;
	document.getElementById("iban").innerHTML = iban;
	document.getElementById("bic").innerHTML = bic;
	document.getElementById("betrag").innerHTML = betrag;
	document.getElementById("waehrung").innerHTML = waehrung;
	document.getElementById("verwendungszweck").innerHTML = verwendungszweck;
}

function auslesen () {
	var uebergebeneID = document.getElementById("input3").value;
	var jsonURL = "/zahlung/"+uebergebeneID;
	fetch(jsonURL)
	.then(empfaenger1)
	.then(empfaenger2);	
}

document.getElementById("Button").addEventListener("click", Testdaten_abrufen);
 //neuer Eintrag an REST API senden
function post() {
	//Eingabe auslesen
    var input = {

        empfaenger: document.getElementById("eingabefeld1").value,
        iban: document.getElementById("eingabefeld2").value,
        bic: document.getElementById("eingabefeld3").value,
        betrag: document.getElementById("eingabefeld4").value,
        waehrung: document.getElementById("eingabefeld5").value,
        verwendungszweck: document.getElementById("eingabefeld6").value,
    }
 //String in JSON umwandeln
    var json = JSON.stringify(input)
    fetch("/zahlung/",
        {	//Daten senden
            headers: { "Content-Type": "application/json" },
            method: "POST",
            body: json
        }
	// Bestätigung ausgeben
    ).then(alert("Ihre Überweisung wurde verbucht."))
}

