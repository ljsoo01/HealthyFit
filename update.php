<?php
    $conn = mysqli_connect("127.0.0.1:3307", "root", "", "healthyfit");
    mysqli_query($conn, 'SET NAMES utf8');

    $userEmail = $_POST["userEmail"];
    $userPw = $_POST["userPw"];

    $statement = mysqli_prepare($conn, "UPDATE membertbl SET userPw = ? WHERE userEmail = ?");
    mysqli_stmt_bind_param($statement, "ss", $userPw, $userEmail);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);

    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>
    <html>
       <body>
 
            <form action="<?php $_PHP_SELF ?>" method="POST">
                userEmail: <input type = "text" name = "userEmail" />
                userPw: <input type = "text" name = "userPw" />
                <input type = "submit" name = "submit" />
            </form>
       
       </body>
    </html>