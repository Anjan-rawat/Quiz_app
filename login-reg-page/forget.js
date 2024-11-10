document.getElementById("forgot-password-form").addEventListener("submit", async function (event) {
  event.preventDefault(); // Prevent form from submitting normally

  // Get user input values from the form
  const email = document.getElementById("email").value;

  const url = "http://localhost:8080/api/forget-password";

  // Prepare the login data as an object
  const emailAddress = {
    email: email
  };

  try {
    // Send a POST request with the email address
    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(emailAddress),
    });

    if (response.ok) {
      const result = await response.text(); // Assuming the backend returns text
      alert("Your Password is " + result); // Display the server's response (e.g., "Login successful!")
    } else {
      alert("Invalid Email."); // Show error if login fails
    }
  } catch (error) {
    console.error("Error during Forget password:", error);
  }
});
