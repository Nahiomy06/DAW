document.addEventListener("DOMContentLoaded", () => {
    const track = document.getElementById("imageTrack");
    const imageWindow = document.getElementById("imageWindow");
    const prevButton = document.getElementById("prevImages");
    const nextButton = document.getElementById("nextImages");

    if (!track || !imageWindow || !prevButton || !nextButton) return;

    let position = 0;

    function updateCarousel() {
        const maxPosition = Math.max(
            0,
            track.scrollWidth - imageWindow.clientWidth,
        );

        position = Math.min(position, maxPosition);
        position = Math.max(position, 0);

        track.style.transform = `translateX(-${position}px)`;

        prevButton.disabled = position <= 0;
        nextButton.disabled = position >= maxPosition - 1;
    }

    function moveCarousel(direction) {
        const firstCard = track.querySelector(".jewel-card");

        if (!firstCard) return;

        const trackStyle = getComputedStyle(track);
        const gap = parseFloat(trackStyle.gap) || 0;
        const step = firstCard.getBoundingClientRect().width + gap;

        const maxPosition = Math.max(
            0,
            track.scrollWidth - imageWindow.clientWidth,
        );

        position = Math.max(
            0,
            Math.min(position + direction * step, maxPosition),
        );

        updateCarousel();
    }

    prevButton.addEventListener("click", () => moveCarousel(-1));
    nextButton.addEventListener("click", () => moveCarousel(1));

    window.addEventListener("resize", updateCarousel);
    window.addEventListener("load", updateCarousel);

    if ("ResizeObserver" in window) {
        new ResizeObserver(updateCarousel).observe(imageWindow);
    }

    updateCarousel();
});
