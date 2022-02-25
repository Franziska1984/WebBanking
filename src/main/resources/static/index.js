
document.getElementById("btn1").addEventListener("click", testDataStart);
document.getElementById("btn2").addEventListener("click", auslesen);
document.getElementById("btn3").addEventListener("click", loeschen);
document.getElementById("btn4").addEventListener("click", post);

function testDataStart() {
    var eingabeUser = document.getElementById("input1").value;
    var url = "/testdaten/" + eingabeUser
    window.location = url;
}
function auslesen () {
	var uebergebeneID = document.getElementById("input2").value;
	var jsonURL = "/zahlung/"+uebergebeneID;
	fetch(jsonURL)
	.then(empfaenger1)
	.then(empfaenger2);	
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
	document.getElementById("empfaenger").innerHTML = empfaenger;
	document.getElementById("iban").innerHTML = iban;
	document.getElementById("bic").innerHTML = bic;
	document.getElementById("betrag").innerHTML = betrag;
	document.getElementById("waehrung").innerHTML = waehrung;
	document.getElementById("verwendungszweck").innerHTML = verwendungszweck;
}

function loeschen () {
	var uebergebeneID = document.getElementById("input3").value;
	var json = "/zahlung/"+uebergebeneID;
    fetch(json,
        {	
            headers: { "Content-Type": "application/json" },
            method: "DELETE",
            body: json
        }
    ).then(alert("Ihre Überweisung wurde gelöscht."))
}

function post() {		//neuer Eintrag an REST API senden
	var input = {		//Eingabe auslesen

        empfaenger: document.getElementById("eingabefeld1").value,
        iban: document.getElementById("eingabefeld2").value,
        bic: document.getElementById("eingabefeld3").value,
        betrag: document.getElementById("eingabefeld4").value,
        waehrung: document.getElementById("eingabefeld5").value,
        verwendungszweck: document.getElementById("eingabefeld6").value,
    }
    var json = JSON.stringify(input)   //String in JSON umwandeln
    fetch("/zahlung/",
        {	//Daten senden
            headers: { "Content-Type": "application/json" },
            method: "POST",
            body: json
        }
    ).then(alert("Ihre Überweisung wurde verbucht.")) // Bestätigung ausgeben
}

var xValues = ["Franzi", "Marco", "Peggy", "Oli"];
var yValues = [55, 49, 44, 24];
var barColors = ["red", "green","blue","orange"];

new Chart("myChart", {
  type: "bar",
  data: {
    labels: xValues,
    datasets: [{
      backgroundColor: barColors,
      data: yValues
    }]
  },
  options: {
    legend: {display: false},
    title: {
      display: true,
      text: "Überweisungen in einem Diagramm"
    }
  }
});