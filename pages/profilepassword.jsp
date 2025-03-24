<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kaicourses | Profile</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>
    <script src="js/profilepassword.js"></script>
</head>
<body>
<div class="bg-gray-50">
    <div>
        <div x-data="{ open: false }" class="relative pb-32 overflow-hidden bg-gradient-to-r from-pink-400 to-blue-400">
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
                                    <a href="/forwardwishlist"><ion-icon class="  text-gray-50 text-2xl" name="heart"></ion-icon></a>
                                    <span class="absolute top-0 left-auto px-1 py-0 -ml-1 text-xs text-white bg-red-500 rounded-full">0</span>
                                </div>
                            </div>
                            <div class="flex flex-col items-center justify-center px-2 py-1 rounded-md hover:bg-gray-700">
                                <div class="relative">
                                    <a href="/forwardcart"><ion-icon class="  text-gray-50 text-2xl" name="cart"></ion-icon></a>
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

            <header class="relative py-10">
                <div class="px-4 mx-auto max-w-7xl sm:px-6 lg:px-8">
                    <h1 class="text-3xl font-bold tracking-tight text-white">Settings</h1>
                </div>
            </header>
        </div>

        <main class="relative -mt-32">
            <div class="max-w-screen-xl px-4 pb-6 mx-auto sm:px-6 lg:px-8 lg:pb-16">
                <div class="overflow-hidden bg-white rounded-lg shadow">
                    <div class="divide-y divide-gray-200 lg:grid lg:grid-cols-12 lg:divide-y-0 lg:divide-x">
                        <aside class="py-6 lg:col-span-3">
                            <nav class="space-y-1">

                                <a href="/profiledefault.jsp"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state:on="Current" x-state:off="Default" aria-current="page"
                                   x-state-description="Current: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, Default: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="person-circle-outline"></ion-icon>
                                    <span class="truncate">Profile</span>
                                </a>

                                <a href="/profileaccount.jsp"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="cog-outline"></ion-icon>
                                    <span class="truncate">Account</span>
                                </a>

                                <a href="/profilepassword.jsp"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-teal-700 border-l-4 border-teal-500 bg-teal-50 hover:bg-teal-50 hover:text-teal-700 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-700" name="key-outline"></ion-icon>
                                    <span class="truncate">Password</span>
                                </a>

                                <a href="/rewards"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="gift-outline"></ion-icon>
                                    <span class="truncate">Rewards</span>
                                </a>

                                <a href="/historyOrdered"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="bag-check-outline"></ion-icon>
                                    <span class="truncate">History</span>
                                </a>

                                <a href="#"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="notifications-outline"></ion-icon>
                                    <span class="truncate">Notifications</span>
                                </a>

                                <a href="#"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="wallet-outline"></ion-icon>
                                    <span class="truncate">Payment</span>
                                </a>

                                <a href="#"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="logo-electron"></ion-icon>
                                    <span class="truncate">Integrations</span>
                                </a>
                                <a href="/logout"
                                   class="flex items-center px-3 py-2 text-sm font-medium text-gray-900 border-l-4 border-transparent hover:bg-gray-50 hover:text-gray-900 group"
                                   x-state-description="undefined: &quot;bg-teal-50 border-teal-500 text-teal-700 hover:bg-teal-50 hover:text-teal-700&quot;, undefined: &quot;border-transparent text-gray-900 hover:bg-gray-50 hover:text-gray-900&quot;">
                                    <ion-icon class="mr-2 text-3xl text-gray-500 group-hover:text-gray-700" name="log-out-outline"></ion-icon>
                                    <span class="truncate">Log out</span>
                                </a>
                            </nav>
                        </aside>

                        <form id="productPasswordForm" class="divide-y divide-gray-200 lg:col-span-9" onsubmit="updatePasswordProcessing(event)">
                            <input type="hidden" id="username" name="username" value="${sessionScope.user.getUsername()}">
                            <!-- Profile section -->
                            <div class="px-4 py-6 sm:p-6 lg:pb-8">
                                <div>
                                    <h2 class="text-2xl font-medium leading-6 text-gray-900">Password</h2>
                                    <p class="mt-1 text-sm text-gray-600">This information will be displayed publicly so be careful what
                                        you share.</p>
                                    <p class="mt-6 text-xl font-bold text-indigo-600">Change password</p>
                                </div>
                                <div class="grid grid-cols-12 gap-6 mt-6">
                                    <div class="col-span-12 sm:col-span-7">
                                        <label for="oldPassword" class="block text-sm font-medium text-gray-700">Password</label>
                                        <input placeholder="Your password" type="password" name="oldPassword" id="oldPassword" autocomplete="family-name" class="block w-full px-3 py-2 mt-1 border border-gray-300 rounded-md shadow-sm focus:border-sky-500 focus:outline-none focus:ring-sky-500 sm:text-sm">
                                    </div>

                                    <div class="col-span-12 sm:col-span-7">
                                        <label for="newPassword" class="block text-sm font-medium text-gray-700">New Password</label>
                                        <input placeholder="Enter new password" type="password" name="newPassword" id="newPassword" class="block w-full px-3 py-2 mt-1 border border-gray-300 rounded-md shadow-sm focus:border-sky-500 focus:outline-none focus:ring-sky-500 sm:text-sm">
                                    </div>

                                    <div class="col-span-12 sm:col-span-7">
                                        <label for="confirmPassword" class="block text-sm font-medium text-gray-700">Confirm Password</label>
                                        <input placeholder="Enter new password again" type="password" name="confirmPassword" id="confirmPassword" class="block w-full px-3 py-2 mt-1 border border-gray-300 rounded-md shadow-sm focus:border-sky-500 focus:outline-none focus:ring-sky-500 sm:text-sm">
                                    </div>

                                </div>
                            </div>
                            <div class="flex justify-end px-4 py-4 mt-4 sm:px-6">
                                <button type="button" class="inline-flex justify-center px-4 py-2 text-sm font-medium text-gray-700 bg-white border border-gray-300 rounded-md shadow-sm hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-sky-500 focus:ring-offset-2">Cancel</button>
                                <button type="submit" class="inline-flex justify-center px-4 py-2 ml-5 text-sm font-medium text-white border border-transparent rounded-md shadow-sm bg-sky-700 hover:bg-sky-800 focus:outline-none focus:ring-2 focus:ring-sky-500 focus:ring-offset-2">Save</button>
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

    </main>
</div>

</div>
</body>
</html>

