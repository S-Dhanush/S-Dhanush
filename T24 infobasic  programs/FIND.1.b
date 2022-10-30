* @ValidationCode : Mjo4Nzk3Mjk5OTM6Q3AxMjUyOjE2NTk1OTczMTQyNTY6RFMwMDg0Mzg1NjotMTotMTowOjA6ZmFsc2U6Ti9BOlIyMV9TUDEzLjA6LTE6LTE=
* @ValidationInfo : Timestamp         : 04 Aug 2022 12:45:14
* @ValidationInfo : Encoding          : Cp1252
* @ValidationInfo : User Name         : DS00843856
* @ValidationInfo : Nb tests success  : N/A
* @ValidationInfo : Nb tests failure  : N/A
* @ValidationInfo : Rating            : N/A
* @ValidationInfo : Coverage          : N/A
* @ValidationInfo : Strict flag       : N/A
* @ValidationInfo : Bypass GateKeeper : false
* @ValidationInfo : Compiler Version  : R21_SP13.0
* @ValidationInfo : Copyright Temenos Headquarters SA 1993-2021. All rights reserved.
PROGRAM FIND.1
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
    FRIEND.LIST="BOB BUILDER":@FM:"ARTIST":@FM:"123456":@VM:"124680":@FM:"MUSIC":@VM:"PAINTING":@VM:"BAKING":@FM:"INDIA":@SM:"TAJ MAHAL":@SM:"CHENNAI":@VM:"UK":@SM:"BIG BEN":@FM:"BLUE"
    FRIEND.LIST<4,2,-1>="HORROR"
    FIND "BAKING" IN FRIEND.LIST SETTING F1,F2,F3 THEN
        CRT"FOUND IN " :F1:" ":F2:" ":F3
    END
