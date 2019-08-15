REPLACE INTO `roles` VALUES (1,'ROLE_ADMINISTRATOR');
REPLACE INTO `roles` VALUES (2,'ROLE_MANAGER');
REPLACE INTO `roles` VALUES (3,'ROLE_CUSTOMER');

REPLACE INTO `users` VALUES (1, 1, 'fnduwayo@mum.edu','Fabrice Nduwayo', '$2a$10$qi7T0NbbwdCB7zfmDN/FW.S3Z1sO2wT7/U8U6ehzFbLIeVRYrsGcG', '3126488754','STAFF' );
REPLACE INTO `users` VALUES (2, 1, 'nduwayof@gmail.com','Fabrice Nduwayo', '$2a$10$qi7T0NbbwdCB7zfmDN/FW.S3Z1sO2wT7/U8U6ehzFbLIeVRYrsGcG', '3126488754','CUSTOMER' );

REPLACE INTO `user_role` VALUES(1, 1);
REPLACE INTO `user_role` VALUES(2, 2);