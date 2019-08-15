REPLACE INTO `roles` VALUES (1,'ROLE_ADMINISTRATOR');
REPLACE INTO `roles` VALUES (2,'ROLE_MANAGER');
REPLACE INTO `roles` VALUES (3,'ROLE_CUSTOMER');

REPLACE INTO `users` VALUES (1, 1, 'admin@ugandaairlines.com','Fabrice Nduwayo', '$2a$10$qi7T0NbbwdCB7zfmDN/FW.S3Z1sO2wT7/U8U6ehzFbLIeVRYrsGcG', '3126488754','STAFF' );
REPLACE INTO `users` VALUES (2, 1, 'manager@ugandaairlines.com','Fabrice Nduwayo', '$2a$10$qi7T0NbbwdCB7zfmDN/FW.S3Z1sO2wT7/U8U6ehzFbLIeVRYrsGcG', '3126488754','STAFF' );

REPLACE INTO `user_role` VALUES(1, 1);
REPLACE INTO `user_role` VALUES(2, 2);

REPLACE INTO `aircraft` VALUES (1, 'Boeing 787-8', 15, 30, 'B78X');
REPLACE INTO `aircraft` VALUES (2, 'Boeing 787-8', 15, 45, 'B788');

REPLACE INTO `airport` VALUES (1, 'ETB', 'Entebbe Internamtional Airport', 'Entebbe', 'Uganda');
REPLACE INTO `airport` VALUES (2, 'NBO', 'JKIA Nairobi', 'Nairobi', 'Kenya');
REPLACE INTO `airport` VALUES (3, 'KGL', 'Kigali International Airport', 'Kigali', 'Rwanda');