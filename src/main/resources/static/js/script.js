document.addEventListener("DOMContentLoaded", () => {
    // Menu link click event
    document.querySelectorAll(".menu-link").forEach(menuLink => {
        menuLink.addEventListener("click", function () {
            document.querySelectorAll(".menu-link").forEach(link => link.classList.remove("is-active"));
            this.classList.add("is-active");
        });
    });

    // Main header link click event
    document.querySelectorAll(".main-header-link").forEach(headerLink => {
        headerLink.addEventListener("click", function () {
            document.querySelectorAll(".main-header-link").forEach(link => link.classList.remove("is-active"));
            this.classList.add("is-active");
        });
    });

    // Dropdown click event
    const dropdowns = document.querySelectorAll(".dropdown");
    dropdowns.forEach(dropdown => {
        dropdown.addEventListener("click", (e) => {
            e.stopPropagation();
            dropdowns.forEach(c => c.classList.remove("is-active"));
            dropdown.classList.add("is-active");
        });
    });

    // Search bar focus and blur events
    const searchBar = document.querySelector(".search-bar input");
    const header = document.querySelector(".header");
    searchBar.addEventListener("focus", () => {
        header.classList.add("wide");
    });
    searchBar.addEventListener("blur", () => {
        header.classList.remove("wide");
    });

    // // Document click event for dropdown
    // document.addEventListener("click", (e) => {
    //   const container = document.querySelector(".status-button");
    //   const dd = document.querySelectorAll(".dropdown");
    //   if (!container.contains(e.target)) {
    //     dd.forEach(d => d.classList.remove("is-active"));
    //   }
    // });

    // // Dropdown overlay events
    // document.querySelectorAll(".dropdown").forEach(dropdown => {
    //   dropdown.addEventListener("click", (e) => {
    //     document.querySelector(".content-wrapper").classList.add("overlay");
    //     e.stopPropagation();
    //   });
    // });

    // document.addEventListener("click", (e) => {
    //   if (!e.target.classList.contains("dropdown")) {
    //     document.querySelector(".content-wrapper").classList.remove("overlay");
    //   }
    // });

    // // Status button and pop-up events
    // document.querySelectorAll(".status-button:not(.open)").forEach(button => {
    //   button.addEventListener("click", () => {
    //     document.querySelector(".overlay-app").classList.add("is-active");
    //     document.querySelector(".pop-up").classList.add("visible");
    //   });
    // });

    // document.querySelector(".pop-up .close").addEventListener("click", () => {
    //   document.querySelector(".overlay-app").classList.remove("is-active");
    //   document.querySelector(".pop-up").classList.remove("visible");
    // });

    // Toggle dark-light mode
    const toggleButton = document.querySelector('.dark-light');
    toggleButton.addEventListener('click', () => {
        document.body.classList.toggle('light-mode');
    });
});
