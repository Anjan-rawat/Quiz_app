
document
  .querySelector(".signup-form")
  .addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent form from submitting and refreshing the page
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    // Create a user object
    const user = {
      name: name,
      email: email,
      password: password
    };

    // Send the user object to the Spring Boot API
    fetch("http://localhost:8080/api/signup", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(user),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Success:", data);
        alert("Registered successfully!"); // Optional: Show a success message

        localStorage.setItem("isLoggedIn", "true");
        window.location.href = `/home-page/index.html`;
      })
      .catch((error) => {
        console.error("Error:", error);
        alert("Error adding user."); // Optional: Show an error message
      });
  });
