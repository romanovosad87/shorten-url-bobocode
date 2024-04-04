<!DOCTYPE html>
<html>
<head>
    <title>Url Shortener</title>
    <style>
        /* Basic CSS for styling */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        label {
            font-weight: bold;
            color: #555;
        }

        input[type="text"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            transition: border-color 0.3s;
        }

        input[type="text"]:focus {
            outline: none;
            border-color: #007bff;
        }

        button {
            padding: 12px 24px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Url Shortener</h1>
    <form action="/short" method="post">
        <label for="inputString">Original URL:</label>
        <input type="text" id="inputUrl" name="inputUrl" required>
        <button type="submit">Shorten</button>
    </form>
    <br>
    <label for="outputString">Shorten URL:</label>
    <td>
        <p id="outputString">${shortenUrl}</p>
    </td>
</div>
</body>
</html>
