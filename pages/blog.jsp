<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <link href="css/blog.css" rel="stylesheet">
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&family=Inconsolata:wght@200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <title>Kaicourses | Blogs</title>
</head>
<body>
<div>
    <header>
        <nav class="flex items-center justify-between p-6 lg:px-8" aria-label="Global">
            <div class="flex lg:flex-1">
                <a href="/index.jsp" class="-m-1.5 p-1.5">
                    <span class="sr-only">Your Company</span>
                    <img class="w-24 h-14" src="img/phonex_logo_prev_ui.png" alt="">
                </a>
            </div>
            <div class="flex lg:hidden">
                <button type="button" class="-m-2.5 inline-flex items-center justify-center rounded-md p-2.5 text-gray-700">
                    <span class="sr-only">Open main menu</span>
                    <svg class="size-6" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" aria-hidden="true" data-slot="icon">
                        <path stroke-linecap="round" stroke-linejoin="round" d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5" />
                    </svg>
                </button>
            </div>
            <div class="hidden lg:flex lg:gap-x-12">
                <a href="/productlist" class="font-semibold text-gray-900 text-sm/6 hover:text-purple-700">Marketplace</a>
                <div class="dropdown">
                    <a href="#" class="font-semibold text-gray-900 text-sm/6 hover:text-purple-700">Categories</a>
                    <ul class="dropdown-menu">
                        <li><a href="#" class="dropdown-item hover:text-purple-700">Category 1</a></li>
                        <li><a href="#" class="dropdown-item hover:text-purple-700">Category 2</a></li>
                        <li><a href="#" class="dropdown-item hover:text-purple-700">Category 3</a></li>
                    </ul>
                </div>
                <a href="#" class="font-semibold text-gray-900 text-sm/6 hover:text-purple-700">Reviews</a>
                <a href="/contact.jsp" class="font-semibold text-gray-900 text-sm/6 hover:text-purple-700">Contact us</a>
                <a href="/blog.jsp" class="font-semibold text-gray-900 text-sm/6 hover:text-purple-700">Blogs</a>
            </div>
            <div class="hidden lg:flex lg:flex-1 lg:justify-end">
                <a href="#" class="font-semibold text-gray-900 text-sm/6 hover:text-purple-700">Sign in <span aria-hidden="true">&rarr;</span></a>
            </div>
        </nav>
    </header>
    <div class="p-4 font-sans mt-10 mb-10">
        <div class="max-w-5xl mx-auto max-lg:max-w-3xl max-md:max-w-md">
            <h2 class="text-3xl font-extrabold text-gray-800">LATEST BLOGS</h2>
            <div class="grid grid-cols-1 gap-6 mt-12 md:grid-cols-2 lg:grid-cols-3">
                <div class="overflow-hidden bg-purple-100 rounded-md cursor-pointer group">
                    <div class="relative overflow-hidden">
                        <img src="https://readymadeui.com/images/food22.webp" alt="Blog Post 3" class="object-cover w-full transition-all duration-300 h-60 group-hover:scale-125" />
                        <div class="px-4 py-2.5 text-white text-sm tracking-wider bg-pink-500 absolute bottom-0 right-0">August 16, 2023</div>
                    </div>
                    <div class="p-6">
                        <h3 class="text-xl font-bold text-gray-800">Lorem Ipsum Dolor</h3>
                        <button type="button" class="px-4 py-2 mt-6 text-sm tracking-wider text-white bg-pink-500 border-none rounded-md outline-none hover:bg-pink-600">Read More</button>
                    </div>
                </div>
                <div class="overflow-hidden bg-purple-100 rounded-md cursor-pointer group">
                    <div class="relative overflow-hidden">
                        <img src="https://readymadeui.com/images/food11.webp" alt="Blog Post 3" class="object-cover w-full transition-all duration-300 h-60 group-hover:scale-125" />
                        <div class="px-4 py-2.5 text-white text-sm tracking-wider bg-pink-500 absolute bottom-0 right-0">August 16, 2023</div>
                    </div>
                    <div class="p-6">
                        <h3 class="text-xl font-bold text-gray-800">Consectetur Adipiscing</h3>
                        <button type="button" class="px-4 py-2 mt-6 text-sm tracking-wider text-white bg-pink-500 border-none rounded-md outline-none hover:bg-pink-600">Read More</button>
                    </div>
                </div>
                <div class="overflow-hidden bg-purple-100 rounded-md cursor-pointer group">
                    <div class="relative overflow-hidden">
                        <img src="https://readymadeui.com/images/food.webp" alt="Blog Post 3" class="object-cover w-full transition-all duration-300 h-60 group-hover:scale-125" />
                        <div class="px-4 py-2.5 text-white text-sm tracking-wider bg-pink-500 absolute bottom-0 right-0">August 16, 2023</div>
                    </div>
                    <div class="p-6">
                        <h3 class="text-xl font-bold text-gray-800">Lorem Ipsum Sit Amet</h3>
                        <button type="button" class="px-4 py-2 mt-6 text-sm tracking-wider text-white bg-pink-500 border-none rounded-md outline-none hover:bg-pink-600">Read More</button>
                    </div>
                </div>
                <div class="overflow-hidden bg-purple-100 rounded-md cursor-pointer group">
                    <div class="relative overflow-hidden">
                        <img src="https://readymadeui.com/images/food33.webp" alt="Blog Post 1" class="object-cover w-full transition-all duration-300 h-60 group-hover:scale-125" />
                        <div class="px-4 py-2.5 text-white text-sm tracking-wider bg-pink-500 absolute bottom-0 right-0">June 10, 2023</div>
                    </div>
                    <div class="p-6">
                        <h3 class="text-xl font-bold text-gray-800">A Guide to Igniting Your Imagination</h3>
                        <button type="button" class="px-4 py-2 mt-6 text-sm tracking-wider text-white bg-pink-500 border-none rounded-md outline-none hover:bg-pink-600">Read More</button>
                    </div>
                </div>
                <div class="overflow-hidden bg-purple-100 rounded-md cursor-pointer group">
                    <div class="relative overflow-hidden">
                        <img src="https://readymadeui.com/images/food44.webp" alt="Blog Post 2" class="object-cover w-full transition-all duration-300 h-60 group-hover:scale-125" />
                        <div class="px-4 py-2.5 text-white text-sm tracking-wider bg-pink-500 absolute bottom-0 right-0">April 20, 2023</div>
                    </div>
                    <div class="p-6">
                        <h3 class="text-xl font-bold text-gray-800">Hacks to Supercharge Your Day</h3>
                        <button type="button" class="px-4 py-2 mt-6 text-sm tracking-wider text-white bg-pink-500 border-none rounded-md outline-none hover:bg-pink-600">Read More</button>
                    </div>
                </div>
                <div class="overflow-hidden bg-purple-100 rounded-md cursor-pointer group">
                    <div class="relative overflow-hidden">
                        <img src="https://readymadeui.com/images/food55.webp" alt="Blog Post 3" class="object-cover w-full transition-all duration-300 h-60 group-hover:scale-125" />
                        <div class="px-4 py-2.5 text-white text-sm tracking-wider bg-pink-500 absolute bottom-0 right-0">August 16, 2023</div>
                    </div>
                    <div class="p-6">
                        <h3 class="text-xl font-bold text-gray-800">Trends and Predictions</h3>
                        <button type="button" class="px-4 py-2 mt-6 text-sm tracking-wider text-white bg-pink-500 border-none rounded-md outline-none hover:bg-pink-600">Read More</button>
                    </div>
                </div>
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
