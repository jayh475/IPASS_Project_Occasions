
function LogOut() {
        console.log("there is an JWT in the storage it will be removed");
        sessionStorage.removeItem("myJWT");
        sessionStorage.removeItem("myUsername");

        console.log("sessionstorage is removed");
        alert("je bent nu uitgelogd");
        uitgelogd();
        location.reload();
}

function uitgelogd(){
    //verbergt admin functies
    let o = document.getElementsByClassName("verberg1");
    let j;
    for(j=0; j<o.length; j++){
        o[j].style.display = "none";
    }
    //verbergt normale user functies
    let x = document.getElementsByClassName("verberg");
    let i;
    for(i=0; i<x.length; i++){
        x[i].style.display = "none";
    }
    document.getElementById("inlogButton").style.display = "block";
    
}



