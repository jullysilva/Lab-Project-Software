import React, { useState } from "react";
import Cadastro from "./Cadastro";

const Home = () => {
  const [showForm, setShowForm] = useState(false);

  return (
    <>
      <div className="mt-5 d flex justify content-left">
        <form action="/action_page.php">
          <div class="container">
            <h1>Register</h1>
            <p>Please fill in this form to create an account.</p>

            <label for="email">
              <b>Email</b>
            </label>
            <input
              type="text"
              placeholder="Enter Email"
              name="email"
              id="email"
              required
            />

            <label for="psw">
              <b>Senha</b>
            </label>
            <input
              type="password"
              placeholder="Enter Password"
              name="psw"
              id="psw"
              required
            />

            <label for="psw-repeat">
              <b>Repeat Password</b>
            </label>
            <input
              type="password"
              placeholder="Repeat Password"
              name="psw-repeat"
              id="psw-repeat"
              required
            />
            <p>
              By creating an account you agree to our{" "}
              <a href="#">Terms & Privacy</a>.
            </p>

            <button
              type="submit"
              class="registerbtn"
              onClick={() => setShowForm(true)}
            >
              Register
            </button>
          </div>

          <div class="container signin">
            <p>
              Already have an account? <a href="#">Sign in</a>.
            </p>
          </div>
        </form>
      </div>
      {showForm && <Cadastro />}
    </>
  );
};

export default Home;
