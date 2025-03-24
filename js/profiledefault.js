function updateProfileDefault(event){
    event.preventDefault();
    fetch('/updateProfileDefault', {
        method: 'POST',
        body: new FormData(document.getElementById('profileDefaultForm')),
    }).then(response => {
        return response.json();
    })
        .then(data => {
            if(data.status){
                Swal.fire({
                    title: 'Update successfully',
                    icon: 'success',
                    timer: 1200,
                    showConfirmButton: false
                });
            } else {
                Swal.fire({
                    title: 'Update failed',
                    text: 'File image not contains special characters',
                    icon: 'error',
                    timer: 1200,
                    showConfirmButton: false
                });
            }
        }).catch(error => {
            console.log(error);
            Swal.fire({
                title: 'Update failed',
                text: 'File image not contains special characters',
                icon: 'error',
                timer: 1200,
                showConfirmButton: false
            });
    })
}

function onChangeImageInProfileUser(event) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            document.getElementById('imageStatic').src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
}