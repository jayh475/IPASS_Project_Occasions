function getMessages(message) {
    console.log("berichten worden weergegeven");
    return `
<div class="messageTemplate">
    <p><strong>naam:</strong> ${message.name} ${message.lastname}</p>
      <p><strong>email:</strong>${message.email}</p>
    <p><strong>onderwerp:</strong>${message.topic} </p>
    <p><strong>bericht:</strong> ${message.question} </p>
    <p><strong>Datum:</strong> ${message.date} </p>
    
</div> `
}

function sendMessage() {
        var formData = new FormData(document.querySelector("#contactForm"));
        var encData = new URLSearchParams(formData.entries());
        var fetchOptions = {
            method: "POST",
            body: encData
        };

        fetch("restservices/messages/create", fetchOptions)
            .then(function (response) {
                if (response.status === 200) {
                    alert("Bericht is verzonden");
                    console.log(response);
                } else if (response.status === 404) {
                    alert("Voer alle velden in!");
                }
                else {
                    alert("er is iets mis gegaan....");
                    console.log("er is iets anders miss gegaan");
                }

            })
}




