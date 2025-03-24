function signUpFormProcessing() {
    event.preventDefault();

    let username = document.getElementById("txtUsernameRegister").value;
    let email = document.getElementById("txtEmailRegister").value;
    let password = document.getElementById("txtPasswordRegister").value;
    let isValid = true;

    if (!/^[a-zA-Z0-9]+$/.test(username)) {
        document.getElementById("errorUsernameRegister").textContent = "Username must contain only letters and numbers.";
        isValid = false;
    }

    if (password.length < 6) {
        document.getElementById("errorPasswordRegister").textContent = "Password must be at least 6 characters.";
        isValid = false;
    } else if (!/^[a-zA-Z0-9@#!$%*&]+$/.test(password)) {
        document.getElementById("errorPasswordRegister2").textContent = "Password must contain only [a-z A-Z 0-9 !@#$%&*]";
        isValid = false;
    }

    if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
        document.getElementById("errorEmailRegister").textContent = "Invalid email format.";
        isValid = false;
    }

    if (isValid) {
        fetch('/register', {
            method: 'POST',
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
            body: `username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}&email=${encodeURIComponent(email)}`
        }).then(response => response.json())
            .then(data => {
                if (data.success) {
                    window.location.href = data.forwardUrl;
                } else {
                    document.getElementById("errorEmailRegister2").textContent = data.message;
                }
            })
            .catch(error => {
                console.log(error);
                window.location.href = error.forwardUrl;
            })
    }
}
