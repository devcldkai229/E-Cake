<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
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
    <title>Kaicourses | Order</title>
    <style>
        /* Ẩn spin buttons trong Chrome, Edge và Safari */
        input[type="number"]::-webkit-inner-spin-button,
        input[type="number"]::-webkit-outer-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }

        /* Ẩn spin buttons trong Firefox */
        input[type="number"] {
            -moz-appearance: textfield;
        }
    </style>
</head>
<body>
<div>
    <nav class="bg-gray-800">
        <div class="px-8 mx-auto max-w-8xl">
            <div class="relative flex items-center justify-between h-16 px-10">
                <div class="absolute inset-y-0 left-0 flex items-center sm:hidden">
                    <button type="button"
                            class="relative inline-flex items-center justify-between p-2 text-gray-400 rounded-md hover:bg-gray-700 hover:text-white focus:outline-none focus:ring-2 focus:ring-inset focus:ring-white"
                            aria-controls="mobile-menu" aria-expanded="false">
                        <span class="absolute -inset-0.5"></span>
                        <span class="sr-only">Open main menu</span>
                        <svg class="block size-6" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                             stroke="currentColor" aria-hidden="true" data-slot="icon">
                            <path stroke-linecap="round" stroke-linejoin="round"
                                  d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5"/>
                        </svg>
                        <svg class="hidden size-6" fill="none" viewBox="0 0 24 24" stroke-width="1.5"
                             stroke="currentColor" aria-hidden="true" data-slot="icon">
                            <path stroke-linecap="round" stroke-linejoin="round" d="M6 18 18 6M6 6l12 12"/>
                        </svg>
                    </button>
                </div>
                <div class="flex items-center justify-center flex-1 sm:items-center sm:justify-start">
                    <a href="/home" class="cursor-pointer">
                        <div class="flex items-center shrink-0">
                            <img class="w-auto h-12" src="img/phonex_logo_prev_ui.png" alt="">
                        </div>
                    </a>
                    <div class="hidden sm:ml-6 sm:block">
                        <div class="flex space-x-4">
                            <a href="/productlist" class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white"
                               aria-current="page">Marketplace</a>
                            <a href="/trackingorder.jsp"
                               class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white">Track the order</a>
                            <a href="#"
                               class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white">Promotion</a>
                            <a href="/blog.jsp"
                               class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white">Blogs</a>
                            <div class="flex items-center">
                                <form action="searchproduct">
                                    <div class="bg-gray-800 flex px-2 py-2 border-b-2 border-[#333] focus-within:border-red-400 overflow-hidden max-w-md mx-auto font-[sans-serif]">
                                        <ion-icon class="mr-3 text-xl font-semibold text-gray-200 focus-within:text-red-400" name="search"></ion-icon>
                                        <input name="txtNameProductToSearch" type="text" class="w-full text-sm text-white bg-gray-800 outline-none" />
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class='flex items-center space-x-5 sm:space-x-3 '>
                    <div class="flex flex-col items-center justify-center gap-0.5 cursor-pointer px-2 py-1 rounded-md hover:bg-gray-700">
                        <div class="relative">
                            <a href="/forwardwishlist"><ion-icon class=" fill-[#333] text-gray-50 text-2xl" name="heart"></ion-icon></a>
                            <span class="absolute top-0 left-auto px-1 py-0 -ml-1 text-xs text-white bg-red-500 rounded-full">0</span>
                        </div>
                    </div>
                    <div class="flex flex-col items-center justify-center px-2 py-1 rounded-md hover:bg-gray-700">
                        <div class="relative">
                            <a href="/forwardcart"><ion-icon class=" fill-[#333] text-gray-50 text-2xl" name="cart"></ion-icon></a>
                            <span id="totalProductsOfCart" class="absolute top-0 left-auto px-1 py-0 -ml-1 text-xs text-white bg-red-500 rounded-full">${sessionScope.totalQuantity}</span>
                        </div>
                    </div>
                    <c:if test="${empty user}">
                        <a href="/login.jsp" class='px-4 py-2 text-sm text-white transition-all border-2 rounded-full max-lg:hidden hover:bg-indigo-600 hover:text-white hover:border-indigo-600 cursor-pointer'>Sign In</a>
                    </c:if>
                    <c:if test="${not empty user}">
                        <a href="/profiledefault.jsp" class="flex items-center font-light text-gray-100 text-md"><p>Welcome</p> <span class="text-red-400 font-bold">,   ${user.getUsername()}</span><img class="w-auto h-10 ml-2 rounded-full" src="img/${user.getImageUrl()}"></a>
                    </c:if>
                    <button id="toggleOpen" class='lg:hidden'>
                        <svg class="w-7 h-7" fill="#333" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                  d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z"
                                  clip-rule="evenodd"></path>
                        </svg>
                    </button>
                </div>
            </div>
        </div>
    </nav>
    <div class="font-[sans-serif] bg-white p-20">
        <div class="flex h-full gap-12 max-sm:flex-col max-lg:gap-4">
            <div class="bg-gray-100 sm:h-screen sm:sticky sm:top-0 lg:min-w-[370px] sm:min-w-[300px]">
                <div class="relative h-full">
                    <div class="px-4 py-8 sm:overflow-auto sm:h-[calc(100vh-60px)]">
                        <div class="space-y-4">
                           <c:forEach var="item" items="${cartItemList}">
                                <div class="flex items-start gap-4">
                                    <div class="flex w-32 p-3 bg-gray-200 rounded-md h-28 max-lg:w-24 max-lg:h-24 shrink-0">
                                        <img src='img/product/${item.getProducts().getProductImgUrl()}' class="object-contain w-full" />
                                    </div>
                                    <div class="w-full">
                                        <h3 class="text-sm text-gray-800 lg:text-base">${item.getProducts().getName()}</h3>
                                        <ul class="mt-3 space-y-1 text-xs text-gray-800">
                                            <li class="flex flex-wrap gap-4">Size <span class="ml-auto">${item.getSize()}</span></li>
                                            <li class="flex flex-wrap gap-4">Quantity <span class="ml-auto">${item.getQuantity()}</span></li>
                                            <li class="flex flex-wrap gap-4">Provided <span class="ml-auto">${item.getSuppliers().getCompanyName()}</span></li>
                                            <li class="flex flex-wrap gap-4">Total Price <span class="ml-auto">$${item.getTotal()}</span></li>
                                        </ul>
                                    </div>
                                </div>
                           </c:forEach>
                        </div>
                    </div>
                    <div class="w-full p-4 bg-gray-200 md:absolute md:left-0 md:bottom-0">
                        <h4 class="flex flex-wrap gap-4 text-sm text-gray-800 lg:text-base">Total <span class="ml-auto">$${finalTotal}</span></h4>
                    </div>
                </div>
            </div>

            <div class="sticky top-0 w-full max-w-4xl px-4 py-8 rounded-md h-max">
                <h2 class="text-2xl font-bold text-gray-800">Complete your order</h2>
                <input type="hidden" value="${shippingFee}" id="shippingFeeOrder">
                <h3 class="text-sm font-bold text-indigo-500 py-1">We sincerely appreciate your confidence in our services</h3>
                <form action="/orders?shippingFee=${shippingFee}&finalTotal=${finalTotal}" class="mt-8" method="post">
                    <div>
                        <h3 class="mb-4 text-sm text-gray-800 lg:text-base">Personal Details</h3>
                        <div class="grid gap-4 md:grid-cols-2">
                            <div>
                                <input required type="text" placeholder="Contact name" name="txtContactName"
                                       class="w-full px-4 py-3 text-sm text-gray-800 bg-gray-100 rounded-md focus:bg-transparent focus:outline-blue-600" />
                            </div>

                            <div>
                                <input required type="number" placeholder="Phone" name="txtPhoneNumber"
                                       class="w-full px-4 py-3 text-sm text-gray-800 bg-gray-100 rounded-md focus:bg-transparent focus:outline-blue-600" />
                            </div>

                            <div>
                                <input required type="email" placeholder="Email" name="txtEmail"
                                       class="w-full px-4 py-3 text-sm text-gray-800 bg-gray-100 rounded-md focus:bg-transparent focus:outline-blue-600" />
                            </div>
                            <div>
                                <input required type="text" placeholder="Address" name="txtAddress"
                                       class="w-full px-4 py-3 text-sm text-gray-800 bg-gray-100 rounded-md focus:bg-transparent focus:outline-blue-600" />
                            </div>
                        </div>
                    </div>

                    <div class="mt-8">
                        <h3 class="mb-4 text-sm text-gray-800 lg:text-base">Notes for your order (optional)</h3>
                        <div class="grid gap-1 md:grid-cols-1">
                            <textarea id="message" name="txtNote" rows="4" class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Write your thoughts here..."></textarea>
                            <p class="text-xs text-gray-500 ms-auto dark:text-gray-400">Remember, notes to this order should be ready essentially! <a href="#" class="text-blue-600 dark:text-blue-500 hover:underline">Supports?</a>.</p>
                        </div>
                        <div>
                            <h3 class="py-5 text-gray-800 text-md">Payment method</h3>
                        </div>
                        <div class="grid gap-4 md:grid-cols-2">
                            <div class="md:col-span-2">
                                <div class="grid gap-4 sm:grid-cols-3">
                                    <!-- Visa Payment Method -->
                                    <div class="flex items-center">
                                        <input type="radio" class="w-5 h-5 cursor-pointer" id="card" name="paymentMethod" value="Visa" onchange="toggleCardInputs()" checked />
                                        <label for="card" class="flex gap-2 ml-4 cursor-pointer">
                                            <img src="https://readymadeui.com/images/visa.webp" class="w-12" alt="card1" />
                                            <img src="https://readymadeui.com/images/american-express.webp" class="w-12" alt="card2" />
                                            <img src="https://readymadeui.com/images/master.webp" class="w-12" alt="card3" />
                                        </label>
                                    </div>

                                    <!-- VNPay Payment Method -->
                                    <div class="flex items-center">
                                        <input type="radio" class="w-5 h-5 cursor-pointer" id="vnpay" name="paymentMethod" value="VnPay" onchange="toggleCardInputs()" />
                                        <label for="vnpay" class="flex gap-2 ml-4 cursor-pointer">
                                            <img src="https://dms.inet.vn/uploads/public/2017/04/27/1493267750016_apps-icon-vnpay.png" class="w-20" alt="vnpay" />
                                        </label>
                                    </div>

                                    <!-- Cash on Delivery Payment Method -->
                                    <div class="flex items-center">
                                        <input type="radio" class="w-5 h-5 cursor-pointer" id="cashondelivery" name="paymentMethod" value="COD" onchange="toggleCardInputs()" />
                                        <label for="cashondelivery" class="flex gap-2 ml-4 cursor-pointer">
                                            <img src="https://png.pngtree.com/png-clipart/20210530/original/pngtree-payment-methods-cash-on-delivery-lebel-with-pickup-van-png-image_6339705.png" class="w-20" alt="cashondelivery" />
                                        </label>
                                    </div>
                                </div>

                                <!-- Card Information Inputs -->
                                <div class="grid gap-4 mt-4 sm:grid-cols-4">
                                    <div class="col-span-2">
                                        <input type="number" id="cardNumber" placeholder="Card number"
                                               class="w-full px-4 py-3 text-sm text-gray-800 bg-white border-2 rounded-md outline-none focus:border-blue-500" />
                                    </div>
                                    <div>
                                        <input type="number" id="expiryDate" placeholder="EXP."
                                               class="w-full px-4 py-3 text-sm text-gray-800 bg-white border-2 rounded-md outline-none focus:border-blue-500" />
                                    </div>
                                    <div>
                                        <input type="number" id="cvv" placeholder="CVV"
                                               class="w-full px-4 py-3 text-sm text-gray-800 bg-white border-2 rounded-md outline-none focus:border-blue-500" />
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="flex gap-4 mt-8 max-md:flex-col">
                            <button onclick="cancelOrderAndBackToMarketplace()" class="rounded-md px-4 py-2.5 w-full text-sm tracking-wide bg-transparent hover:bg-gray-100 border border-gray-300 text-gray-800 max-md:order-1">Cancel</button>
                            <button onclick="showConfirmOrderSuccess()" type="submit" class="rounded-md px-4 py-2.5 w-full text-sm tracking-wide bg-blue-600 hover:bg-blue-700 text-white">Order</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <footer class="bg-gray-900 py-6 sm:px-16 max-sm:px-8 font-sans tracking-wide">
        <div class="max-w-xl mx-auto text-center">
            <h4 class="mb-6 text-lg text-white">Join our newsletter to keep up to date with us!</h4>
            <div class="bg-white flex p-1 rounded-full text-left">
                <input type='email' placeholder='Enter your email' class= "rounded-full w-full outline-none text-[15px] pl-4" />
                <button type='button'
                        class="bg-indigo-500 text-white text-[15px] rounded-full px-4 py-2 tracking-wide hover:bg-indigo-600 transition-all">Subscribe</button>
            </div>
        </div>

        <hr class="my-10 border-gray-400" />

        <div class="grid grid-cols-1 gap-8 sm:grid-cols-2 lg:grid-cols-5">
            <div class="max-w-md lg:col-span-2">
                <h4 class="mb-4 text-lg font-bold text-gray-200">Follow us</h4>
                <ion-icon class="text-3xl text-gray-200 cursor-pointer hover:text-blue-500" name="logo-facebook"></ion-icon>
                <ion-icon class="text-3xl text-gray-200 cursor-pointer hover:text-yellow-500" name="logo-github"></ion-icon>
                <ion-icon class="text-3xl text-gray-200 cursor-pointer hover:text-blue-500" name="logo-twitter"></ion-icon>
                <ion-icon class="text-3xl text-gray-200 cursor-pointer hover:text-green-500" name="logo-edge"></ion-icon>
                <ion-icon class="text-3xl text-gray-200 cursor-pointer hover:text-red-500" name="logo-youtube"></ion-icon>
            </div>

            <div>
                <h4 class="mb-6 text-lg text-white">Services</h4>
                <ul class="space-y-4">
                    <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Web
                        Development</a></li>
                    <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Mobile App
                        Development</a></li>
                    <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">UI/UX
                        Design</a></li>
                    <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Digital Marketing</a></li>
                </ul>
            </div>

            <div>
                <h4 class="mb-6 text-lg text-white">Resources</h4>
                <ul class="space-y-4">
                    <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Webinars</a>
                    </li>
                    <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Ebooks</a>
                    </li>
                    <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Templates</a>
                    </li>
                    <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Tutorials</a></li>
                </ul>
            </div>

            <div>
                <h4 class="mb-6 text-lg text-white">About Us</h4>
                <ul class="space-y-4">
                    <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Our Story</a>
                    </li>
                    <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Mission and
                        Values</a></li>
                    <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Team</a></li>
                    <li><a href="javascript:void(0)" class="text-gray-300 hover:text-white text-[15px]">Testimonials</a></li>
                </ul>
            </div>
        </div>

        <p class='text-gray-300 text-[15px] mt-10'>© Kaicourses. Created by devcldkai229.</p>
    </footer>
</div>
</body>
</html>
