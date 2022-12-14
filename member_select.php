<?php
$conn = mysqli_connect("127.0.0.1:3307", "root", "", "healthyfit");
mysqli_query($conn, 'SET NAMES utf8');

$userEmail = $_POST["userEmail"];
$userWeight = $_POST["userWeight"];
$userBMI = $_POST["userBMI"];
$userETC = $_POST["userETC"];
$userHeight = $_POST["userHeight"];

$statement = mysqli_prepare($conn, "SELECT userHeight, userWeight, userBMI, userETC FROM membertbl  WHERE userEmail = ?");
mysqli_stmt_bind_param($statement, "iiiss", $userHeight, $userWeight, $userBMI, $userETC, $userEmail);
mysqli_stmt_execute($statement);

mysqli_stmt_store_result($statement);

$response = array();
$response["success"] = false;

    while(mysqli_stmt_fetch($statement)) {
        $response["success"] = true;
        $response["userEmail"] = $userEmail;
    }

echo json_encode($response);
?>

<html>
   <body>

        <form action="<?php $_PHP_SELF ?>" method="POST">
            userEmail: <input type = "text" name = "userEmail" />

            <input type = "submit" name = "submit" />
        </form>
   
   </body>
</html>