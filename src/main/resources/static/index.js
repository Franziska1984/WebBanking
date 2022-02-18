

function empfaenger1(antwort) {
	var json = antwort.json();
	return json;
}

function empfaenger2(json) {
	var empfaenger = json.Empfaenger;
	var iban = json.Iban;
	var bic = json.Bic;
	var betrag = json.Betrag;
	var waehrung = json.Waehrung;
	var verwendungszweck = json.Verwendungszweck;

	//Ausgabe Bankdaten
	document.getElementById("Output").innerHTML;
	document.getElementById("empfaenger").innerHTML = empfaenger;
	document.getElementById("iban").innerHTML = iban;
	document.getElementById("bic").innerHTML = bic;
	document.getElementById("betrag").innerHTML = betrag;
	document.getElementById("waehrung").innerHTML = waehrung;
	document.getElementById("verwendungszweck").innerHTML = verwendungszweck;
}

function Testdaten_abrufen () {
		
	fetch("test.json")
	.then(empfaenger1)
	.then(empfaenger2);
	
}

document.getElementById("Button").addEventListener("click", Testdaten_abrufen);
