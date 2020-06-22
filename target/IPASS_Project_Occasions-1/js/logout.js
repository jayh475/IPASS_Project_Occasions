
function LogOut() {
    if (sessionStorage["myJWT"]) {
        console.log("there is an JWT in the storage it will be removed");
        sessionStorage.removeItem("myJWT");
        console.log("sessionstorage is removed");
        console.log(sessionStorage.getItem("myJWT"));
        alert("je bent nu uitgelogd")
        location.reload();
    } else {
        alert("sessionstorage is empty cannot loggout");
    }
}



