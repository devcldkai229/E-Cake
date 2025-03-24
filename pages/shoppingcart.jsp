<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kaicourses | Cart</title>
    <link rel="icon" type="image/x-icon" href="/img/phonex_logo_prev_ui.png">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&family=Inconsolata:wght@200;300;400;500;600;700;800;900&display=swap"
          rel="stylesheet">
    <style>
        #summary {
            background-color: #f6f6f6;
        }
    </style>
    <script src="js/shoppingcart.js">
    </script>
    <script src="js/indecreaseitem.js">
    </script>
</head>
<body class="bg-gray-100">
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
                        <div class="flex space-x-4 items-center">
                            <a href="/productlist" class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white"
                               aria-current="page">Marketplace</a>
                            <a href="/trackingorder.jsp"
                               class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white"
                            >Track the order</a>
                            <a href="#"
                               class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white">Promotion</a>
                            <a href="/blog.jsp"
                               class="px-3 py-2 text-sm font-medium text-gray-300 rounded-md hover:bg-gray-700 hover:text-white">Blogs</a>
                            <div class="flex items-center">
                                <form action="searchproduct">
                                    <div class="bg-gray-800 flex mt-4 px-1 py-1 border-b-2 border-[#333] focus-within:border-red-400 overflow-hidden max-w-md mx-auto font-[sans-serif]">
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
                    <div class="flex flex-col items-center justify-center px-2 py-2 rounded-md bg-gray-900">
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
    <div class="container px-10 mx-auto mt-10">
        <div class="flex my-10 shadow-md">
            <div class="w-3/4 px-10 py-10 bg-white">
                <div class="flex justify-between pb-8 border-b">
                    <h1 class="text-2xl font-semibold">Shopping Cart</h1>
                    <h2 id="itemQuantity" class="text-2xl font-semibold">${itemQuantity} Items</h2>
                </div>
                <div class="flex mt-10 mb-5">
                    <h3 class="w-2/5 text-xs font-semibold text-gray-600 uppercase">Product Details</h3>
                    <h3 class="w-1/5 text-xs font-semibold text-center text-gray-600 uppercase">Quantity</h3>
                    <h3 class="w-1/5 text-xs font-semibold text-center text-gray-600 uppercase">Price</h3>
                    <h3 class="w-1/5 text-xs font-semibold text-center text-gray-600 uppercase">Total</h3>
                </div>
                <c:forEach var="item" items="${cartItemList}">
                    <div class="flex items-center px-6 py-5 -mx-8 hover:bg-gray-100">
                        <div class="flex w-2/5"> <!-- product -->
                            <div class="w-20">
                                <img class="h-full" src="img/product/${item.getProducts().getProductImgUrl()}" alt="">
                            </div>
                            <div class="flex flex-col justify-between flex-grow ml-4 space-y-1">
                                <span class="text-lg font-bold text-gray-600">${item.getProducts().getName()}</span>
                                <span class="text-sm text-gray-400">Provided by: ${item.getSuppliers().getCompanyName()}</span>
                                <span class="text-sm text-red-500">Size: ${item.getSize()}</span>
                                <form action="/" method="POST" style="display:inline;">
                                    <input type="hidden" name="idProduct" value="${item.getProducts().getId()}">
                                </form>
                                <form action="/removeitem?idProduct=${item.getProducts().getId()}&currentsize=${item.getSize()}" method="POST" style="display:inline;">
                                    <button type="submit" class="text-xs font-semibold text-gray-500 hover:text-red-500">
                                        <ion-icon class="mr-2" name="trash-outline"></ion-icon>Remove
                                    </button>
                                </form>
                            </div>
                        </div>
                        <div class="flex justify-center w-1/5">
                            <svg onclick="decreaseProcessing(${item.getProducts().getId()}, '${item.getSize()}')" class="decrease w-3 text-gray-600 fill-current cursor-pointer" viewBox="0 0 448 512">
                                <path d="M416 208H32c-17.67 0-32 14.33-32 32v32c0 17.67 14.33 32 32 32h384c17.67 0 32-14.33 32-32v-32c0-17.67-14.33-32-32-32z"/>
                            </svg>

                            <input id="quantityCanBeInDe-${item.getProducts().getId()}-${item.getSize()}" class="w-8 mx-2 text-center border cursor-pointer" type="text" value="${item.getQuantity()}">
                            <input id="productIdHidden-${item.getProducts().getId()}-${item.getSize()}" type="hidden" value="${item.getProducts().getId()}">

                            <svg onclick="increaseProcessing(${item.getProducts().getId()}, '${item.getSize()}')" class="increase w-3 text-gray-600 fill-current cursor-pointer" viewBox="0 0 448 512">
                                <path d="M416 208H272V64c0-17.67-14.33-32-32-32h-32c-17.67 0-32 14.33-32 32v144H32c-17.67 0-32 14.33-32 32v32c0 17.67 14.33 32 32 32h144v144c0 17.67 14.33 32 32 32h32c17.67 0 32-14.33 32-32V304h144c17.67 0 32-14.33 32-32v-32c0-17.67-14.33-32-32-32z"/>
                            </svg>
                        </div>
                        <span id="priceUnit-${item.getProducts().getId()}" class="w-1/5 text-sm font-semibold text-center">$${item.getPriceWithExtra()}</span>
                        <span id="totalChange-${item.getProducts().getId()}-${item.getSize()}" class="w-1/5 text-sm font-semibold text-center">$${item.getTotal()}</span>
                    </div>
                </c:forEach>
                <a href="/productlist" class="flex mt-10 text-sm font-semibold text-indigo-600">
                    <svg class="w-4 mr-2 text-indigo-600 fill-current" viewBox="0 0 448 512"><path d="M134.059 296H436c6.627 0 12-5.373 12-12v-56c0-6.627-5.373-12-12-12H134.059v-46.059c0-21.382-25.851-32.09-40.971-16.971L7.029 239.029c-9.373 9.373-9.373 24.569 0 33.941l86.059 86.059c15.119 15.119 40.971 4.411 40.971-16.971V296z"/></svg>
                    Continue Shopping
                </a>
            </div>

            <div id="summary" class="w-1/4 px-8 py-10">
                <h1 class="pb-8 text-2xl font-semibold border-b">Order Summary</h1>
                <div class="flex justify-between mt-10 mb-5">
                    <span id="totalQuantity" class="text-sm font-semibold uppercase">Items ${totalQuantity}</span>
                    <span id="totalUp" class="text-sm font-semibold">$${total}</span>
                </div>
                <div>
                    <label class="inline-block mb-3 text-sm font-medium uppercase">Shipping</label>
                    <select id="formalSelected" required onchange="updateFinalPriceWithShippingFee()" name="shippingTypes" class="block w-full p-2 text-sm text-gray-600" value="0.0">
                        <option value="0.0">Choose formal delivery</option>
                        <option value="2.0">Standard shipping - $2.0</option>
                        <option value="4.0">Express shipping (1 hour) - $4.0</option>
                    </select>
                </div>
                <div class="py-10">
                    <label for="promo" class="inline-block mb-3 text-sm font-semibold uppercase">Promo Code</label>
                    <input type="text" id="promo" placeholder="Enter your code" class="w-full p-2 text-sm">
                </div>
                <button class="px-5 py-2 text-sm text-white uppercase bg-red-500 hover:bg-red-600">Apply</button>
                <form id="orderForm" class="mt-8 border-t" method="get" onsubmit="updateLinkToOrder(event)">
                    <div class="flex justify-between py-3 text-sm font-semibold uppercase">
                        <span>Total</span>
                        <span id="total">$${total}</span>
                    </div>
                    <div class="flex justify-between py-3 text-sm font-semibold uppercase">
                        <span>Shipping fee</span>
                        <span id="shippingfee">$0.0</span>
                    </div>
                    <div class="flex justify-between py-3 text-sm font-semibold uppercase">
                        <span>DISCOUNT</span>
                        <span>$0.0</span>
                    </div>
                    <div class="flex justify-between py-3 text-sm font-semibold uppercase">
                        <span>Final total</span>
                        <span id="finaltotal">$${total}</span>
                    </div>

                    <!-- Hidden inputs to pass data -->
                    <input type="hidden" id="hiddenFinalTotal" name="finalTotal" value="${total}">
                    <input type="hidden" id="hiddenShippingFee" name="shippingFee" value="0.0">

                    <button type="submit" class="w-full py-3 text-sm font-semibold text-white uppercase bg-indigo-500 hover:bg-indigo-600">Checkout</button>
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
