<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&family=Inconsolata:wght@200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <title>Kaicourses | Details</title>
    <script src="js/productdetails.js"></script>
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
                            <a href="#" class="px-3 py-2 text-sm font-medium text-white bg-gray-900 rounded-md"
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
    <div class="p-2 ml-20 font-sans tracking-wide max-w-7xl max-lg:max-w-2xl max-lg:mx-auto">
        <div>
            <h2 class="text-3xl font-bold text-red-400">${product.getName()}</h2>
            <p class="mt-2 text-lg text-gray-500">Product provided by ${supplier.getCompanyName()}</p>
        </div>

        <div class="grid items-start grid-cols-1 gap-8 mt-6 lg:grid-cols-5">
            <div class="lg:col-span-3">
                <div class="grid gap-2 text-center sm:grid-cols-3">
                    <div class="flex items-center rounded sm:col-span-2">
                        <img src="img/product/${product.getProductImgUrl()}" alt="${product.getName()}" class="w-full aspect-[5/4] object-contain object-top rounded-lg" />
                    </div>
                    <div class="w-full h-full space-y-2 max-sm:grid max-sm:grid-cols-2 max-sm:gap-2">
                        <div class="flex items-center w-full rounded h-1/2 sm:h-[200px]">
                            <img src="https://img.freepik.com/free-photo/pizza-with-mixed-ingredients-cheese-top_114579-3438.jpg?uid=R183697344&ga=GA1.1.1565333554.1736343081&semt=ais_incoming" alt="Product" class="object-contain w-full max-h-full rounded-lg" />
                        </div>
                        <div class=" flex items-center rounded w-full h-1/2 sm:h-[200px]">
                            <img src="https://img.freepik.com/free-photo/crispy-pizza-with-tomatoes-olives-sausages_140725-3549.jpg?uid=R183697344&ga=GA1.1.1565333554.1736343081&semt=ais_incoming" alt="Product" class="object-contain object-top w-full max-h-full rounded-lg" />
                        </div>
                    </div>
                </div>
            </div>
            <div class="w-full lg:col-span-2">
                <p class="text-3xl font-bold text-gray-800">$${priceProductBySize}</p>
                <div class="flex items-center mt-2 space-x-1">
                    <ion-icon class="text-xl text-indigo-500" name="star"></ion-icon>
                    <ion-icon class="text-xl text-indigo-500" name="star"></ion-icon>
                    <ion-icon class="text-xl text-indigo-500" name="star"></ion-icon>
                    <ion-icon class="text-xl text-indigo-500" name="star"></ion-icon>
                    <ion-icon class="text-xl text-gray-300" name="star"></ion-icon>
                    <button type="button" class="px-2.5 py-1.5 bg-gray-100 text-xs text-gray-800 rounded flex items-center !ml-4">
                        <ion-icon name="chatbubbles"></ion-icon>
                        87 Reviews
                    </button>
                </div>
                <div class="mt-6">
                    <h3 class="text-lg font-bold text-gray-800">Choose a size</h3>
                    <div class="flex flex-wrap gap-4 mt-4" >
                        <button type="submit" onclick="processingSizePizza(${product.getId()}, 'S')" class="flex items-center justify-center w-12 h-12 text-sm font-semibold rounded-full hover:border-purple-600 shrink-0 ${currentsize == "S" ? 'text-purple-800 border border-purple-600' : 'text-gray-800 border'}">S</button>
                        <button type="submit" onclick="processingSizePizza(${product.getId()}, 'M')" class="flex items-center justify-center w-12 h-12 text-sm font-semibold rounded-full hover:border-purple-600 shrink-0 ${currentsize == "M" ? 'text-purple-800 border border-purple-600' : 'text-gray-800 border'}">M</button>
                        <button type="submit" onclick="processingSizePizza(${product.getId()}, 'L')" class="flex items-center justify-center w-12 h-12 text-sm font-semibold rounded-full hover:border-purple-600 shrink-0 ${currentsize == "L" ? 'text-purple-800 border border-purple-600' : 'text-gray-800 border'}">L</button>
                        <button type="submit" onclick="processingSizePizza(${product.getId()}, 'XL')" class="flex items-center justify-center w-12 h-12 text-sm font-semibold rounded-full hover:border-purple-600 shrink-0 ${currentsize == "XL" ? 'text-purple-800 border border-purple-600' : 'text-gray-800 border'}">XL</button>
                    </div>
                </div>
                <div class="flex gap-4 mt-6">
                    <button onclick="addToOrderNow(${product.getId()}, '1', '${currentsize}')" type="button" class="w-full px-4 py-3 text-sm font-semibold text-white bg-purple-600 rounded hover:bg-purple-700">Buy now</button>
                    <button onclick="addToCartWithSize(${product.getId()}, '1', '${currentsize}')" class="w-full px-4 py-2.5 border border-purple-600 bg-transparent hover:bg-gray-50 text-gray-800 text-sm font-semibold rounded">Add to cart</button>
                </div>
                <div class="mt-6">
                    <h3 class="text-lg font-bold text-gray-800">Enter E-voucher</h3>
                    <p class="mt-1 text-sm text-gray-500">Enter the code of your voucher to get discount pizza.</p>
                    <div class='flex items-center gap-2 mt-4'>
                        <input type='text'
                               placeholder='Enter pincode' class='bg-white px-4 py-2.5 text-sm w-full border border-gray-300 outline-0 rounded' />
                        <button type='button' class='border border-purple-600 outline-0 bg-purple-600 hover:bg-purple-700 text-white px-4 py-2.5 text-sm rounded'>Apply</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="mt-8 max-w-7xl">
            <ul class="flex border-b">
                <li class="px-8 py-3 text-sm font-bold text-gray-800 transition-all bg-gray-100 border-b-2 border-gray-800 cursor-pointer">
                    Description</li>
                <li class="px-8 py-3 text-sm font-bold text-gray-600 transition-all cursor-pointer hover:bg-gray-100">Reviews</li>
            </ul>
            <div class="mt-8">
                <h3 class="text-lg font-bold text-gray-800">${product.getName()} Description</h3>
                <p class="mt-4 text-md text-gray-600">${product.getDescription()}</p>
            </div>
            <ul class="pl-4 mt-6 space-y-3 text-md text-gray-600 list-disc">
                <li>Our pizzas are crafted with a thin, crispy crust that complements every topping.</li>
                <li>Available in multiple sizes, from personal to family, ensuring the perfect portion for everyone.</li>
                <li>Made with fresh, locally sourced ingredients for a burst of authentic flavor in every bite.</li>
                <li>Customizable with a wide range of toppings to suit your taste preferences, from classic to gourmet options.</li>
                <li>Easy to reheat and enjoy later, keeping its delicious flavor intact.</li>
                <li>Pairs perfectly with a variety of sides and beverages to create a complete meal experience.</li>
            </ul>
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
<script src="js/productoverview.js"></script>
</body>
</html>
