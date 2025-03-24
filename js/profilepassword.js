function updatePasswordProcessing(event){
    event.preventDefault();

    let username = document.getElementById("username").value;
    let oldPassword = document.getElementById("oldPassword").value;
    let newPassword = document.getElementById("newPassword").value;
    let confirmPassword = document.getElementById("confirmPassword").value;

    fetch('/updatePassword', {
        method: 'POST',
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: `username=${encodeURIComponent(username)}&oldPassword=${encodeURIComponent(oldPassword)}&newPassword=${encodeURIComponent(newPassword)}&confirmPassword=${encodeURIComponent(confirmPassword)}`
    }).then(response => response.json())
        .then(data => {
            if(data.status){
                Swal.fire({
                    title: `${data.message}`,
                    icon: "success",
                    timer: 1200,
                    showConfirmButton: false
                })
                document.getElementById("productPasswordForm").reset();
            } else {
                Swal.fire({
                    title: `${data.message}`,
                    icon: "fail",
                    timer: 1200,
                    showConfirmButton: false
                })
                document.getElementById("productPasswordForm").reset();
            }
        }).catch(error => {
            console.log(error);
            Swal.fire({
                title: `${data.message}`,
                icon: "fail",
                timer: 1200,
                showConfirmButton: false
            })
            document.getElementById("productPasswordForm").reset();
    })
}