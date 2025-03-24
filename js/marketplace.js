let currentIndex = 0;
    const carouselImages = document.getElementById("carousel-images");
    const totalSlides = carouselImages.children.length;
    const intervalTime = 3000; // Thời gian tự chuyển (3 giây)
    const transitionTime = 500; // Thời gian hiệu ứng chuyển động (0.5 giây)

    // Cập nhật hiệu ứng transition mượt mà
    carouselImages.style.transition = `transform ${transitionTime}ms ease-in-out`;

    function showSlide(index) {
        if (index >= 0 && index < totalSlides) {
            currentIndex = index;
            const offset = -100 * currentIndex; // Mỗi slide chiếm 100% chiều rộng
            carouselImages.style.transform = `translateX(${offset}%)`;
        }
    }

    function prevSlide() {
        const newIndex = (currentIndex - 1 + totalSlides) % totalSlides; // Lùi lại, quay vòng về cuối nếu cần
        showSlide(newIndex);
    }

    function nextSlide() {
        const newIndex = (currentIndex + 1) % totalSlides; // Tiến tới, quay vòng về đầu nếu cần
        showSlide(newIndex);
    }

    // Tự động chuyển slide sau mỗi khoảng thời gian
    let autoSlide = setInterval(() => {
        nextSlide();
    }, intervalTime);

    // Dừng tự động khi hover và tiếp tục khi rời chuột
    const carouselContainer = document.querySelector('.relative');
    carouselContainer.addEventListener('mouseenter', () => {
        clearInterval(autoSlide);
    });

    carouselContainer.addEventListener('mouseleave', () => {
        autoSlide = setInterval(() => {
            nextSlide();
        }, intervalTime);
    });

    // Đồng bộ thời gian để tránh lỗi hiệu ứng
    carouselImages.addEventListener('transitionend', () => {
        carouselImages.style.transition = `transform ${transitionTime}ms ease-in-out`;
    });



