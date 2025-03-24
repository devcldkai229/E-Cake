function loginPostChecking(){
    event.preventDefault();

    let username = document.getElementById(`txtUsername`).value;
    let password = document.getElementById(`txtPassword`).value;

    fetch('/loginUserServlet',{
        method: 'POST',
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: `username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`
    }).then(response => response.json())
        .then(data => {
            if (data.status) {
                if(data.ROLE === 'USER'){
                    window.location.href = "/home"
                } else {
                    window.location.href = "/adminorderlist"
                }
            } else {
                document.getElementById('messageLoginFailed').innerText = data.message;
            }
        }).catch(error => {
            console.log(error);
    })

}



