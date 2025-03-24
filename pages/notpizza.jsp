<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&family=Inconsolata:wght@200;300;400;500;600;700;800;900&display=swap"
          rel="stylesheet">
    <title>Kaicourses | Checkout</title>
    <script src="js/ordersuccess.js"></script>
</head>
<script>
    function forwardToProduct() {
        window.location.href = '/productlist';
    }
</script>
<body class="bg-gray-50">
<div class="fixed inset-0 px-4 flex flex-wrap justify-center items-center w-full h-full z-[1000] before:fixed before:inset-0 before:w-full before:h-full before:bg-[rgba(0,0,0,0.5)] overflow-auto font-[sans-serif]">
    <div class="relative w-full max-w-lg px-6 py-5 mx-auto text-center bg-white rounded-lg shadow-lg">
        <ion-icon class="text-red-500 text-8xl " name="close-circle-sharp"></ion-icon>

        <div class="mt-6">
            <h3 class="flex-1 text-4xl font-bold text-red-500">Checkout conditions</h3>
            <p class="mt-3 text-gray-600 text-lg font-bold ">Pls your cart is empty</p>

            <button onclick="forwardToProduct()" type="button"
                    class="px-6 py-2.5 mt-8 w-full rounded-md text-white text-sm font-semibold tracking-wide border-none outline-none bg-red-500 hover:bg-red-600 cursor-pointer">Back to marketplace</button>
        </div>
    </div>
</div>
</body>
</html>
