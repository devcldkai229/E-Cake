function sendInfoOTP() {
    let newEmail = document.getElementById("email").value;
    fetch(`/changeEmail?newEmail=${newEmail}`, {
        method: 'GET'
    }).then((response) => response.json())
        .then(data => {
            if(data.status){
                document.getElementById("messageSent").innerText = "sent email successfully!"
            }
        })
        .catch(error => {
            console.log(error);
            document.getElementById("messageSent").innerText = "sent email failed!";
        })
};


function updateEmailProcessing(event){
    event.preventDefault();

    let username = document.getElementById("username").value;
    let email = document.getElementById("email").value;
    let otpCode = document.getElementById("code").value;
    fetch('/updateEmail', {
        method: 'POST',
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: `username=${encodeURIComponent(username)}&email=${encodeURIComponent(email)}&otpCode=${encodeURIComponent(otpCode)}`
    }).then(response => response.json())
        .then(data => {
            if(data.status){
                Swal.fire({
                    title: 'Update successfully',
                    icon: 'success',
                    timer: 1200,
                    showConfirmButton: false
                });
                document.getElementById("messageSent").innerText = "";
                document.getElementById("code").innerText = "Enter your otp code from new email...";
            } else {
                Swal.fire({
                    title: `${data.message}`,
                    icon: 'fail',
                    timer: 1200,
                    showConfirmButton: false
                })
            }
        }).catch(error => {
            console.log(error);
            Swal.fire({
                title: `${error.message}`,
                icon: 'fail',
                timer: 1200,
                showConfirmButton: false
            })
    });
}