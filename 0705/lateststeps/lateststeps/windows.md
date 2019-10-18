C:\Users\万门大学>netstat -ano | findstr 8080
  TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       5768
  TCP    [::]:8080              [::]:0                 LISTENING       5768
  TCP    [2001:0:9d38:6ab8:20:23e1:2df3:9a56]:50395  [2001:0:9d38:6ab8:20:23e1:2df3:9a56]:8080  TIME_WAIT       0

C:\Users\万门大学>tasklist |findstr 5768
java.exe                      5768 Console                    1    562,900 K

C:\Users\万门大学>taskkill /pid 5768 -t -f
成功: 已终止 PID 408 (属于 PID 5768 子进程)的进程。
成功: 已终止 PID 5768 (属于 PID 9708 子进程)的进程。

C:\Users\万门大学>










/resources/static
/resources/static
/resources/application.properties









