function exchangeRewardsProcessing(rewardId){

    Swal.fire({
        title: 'Are you sure to exchange this gift?',
        text: "You won't be able to undo this action!",
        input: "text",
        placeholder: "Enter your address",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, exchange it!',
        cancelButtonText: 'Cancel'
    }).then((result) => {
        if (result.isConfirmed) {
            let address = result.value;
            if (address != null && address.trim() !== "") {
                fetch(`/exchangeRewards?rewardId=${rewardId}&address=${encodeURIComponent(address)}`, {
                    method: 'POST'
                }).then(response => response.json())
                    .then(data => {
                        if (data.status) {
                            document.getElementById("pointUserCurrent").textContent = data.stillPointsAccount;
                            Swal.fire({
                                title: 'Exchanged!',
                                text: 'Your gift has been successfully exchanged. It will be delivered soon.',
                                icon: 'success',
                                timer: 2000
                            });
                        } else {
                            Swal.fire({
                                title: 'Exchange failed!',
                                text: data.message,
                                icon: 'error',
                                timer: 2000
                            });
                        }
                    }).catch(error => {
                        console.error(error);
                        Swal.fire({
                            title: 'Exchange failed!',
                            text: error.message,
                            icon: 'error',
                            timer: 2000
                        });
                });
            } else {
                Swal.fire({
                    title: 'Exchange failed!',
                    text: 'Please enter your address.',
                    icon: 'error',
                    timer: 2000
                });
            }
        }
    });
}
