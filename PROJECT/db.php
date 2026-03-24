<?php
$host = "localhost";
$user = "root";
$pass = "root";
$db = "trendy_steals"; // we'll create this next

$conn = new mysqli($host, $user, $pass, $db);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>
