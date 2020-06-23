function getMessages(message) {
    console.log("berichten worden weergegeven");
    return `
<div class="messageTemplate">
    <p><strong>naam:</strong> ${message.voornaam} ${message.achternaam}</p>
      <p><strong>email:</strong>${message.email}</p>
    <p><strong>onderwerp:</strong>${message.onderwerp} </p>
    <p><strong>bericht:</strong> ${message.bericht} </p>
</div> `
}




