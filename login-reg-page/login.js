document.getElementById("login-form").addEventListener("submit", async function (event) {
  event.preventDefault(); // Prevent form from submitting normally

  // Get user input values from the form
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  const url = "http://localhost:8080/api/login";

  // Prepare the login data as an object
  const loginData = {
    email: email,
    password: password,
  };

  try {
      // Send a POST request with the login data
      const response = await fetch(url, {
          method: "POST",
          headers: {
              "Content-Type": "application/json",
          },
          body: JSON.stringify(loginData),
      });

      if (response.ok) {
          alert("Login successful!"); // Display the server's response
          // Optionally, set a flag in localStorage or sessionStorage
          localStorage.setItem("isLoggedIn", "true");
          window.location.href = `/home-page/index.html`; // Redirect to home page
      } else {
          alert("Login failed: Wrong Email or Password."); // Show error if login fails
      }
  } catch (error) {
      console.error("Error during login:", error);
  }
});
