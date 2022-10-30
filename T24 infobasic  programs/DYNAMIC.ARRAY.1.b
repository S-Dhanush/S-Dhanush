* @ValidationCode : Mjo4ODM5MTkwMDA6Q3AxMjUyOjE2NTk1MTA4MDI2NzM6RFMwMDg0Mzg1NjotMTotMTowOjA6ZmFsc2U6Ti9BOlIyMV9TUDEzLjA6LTE6LTE=
* @ValidationInfo : Timestamp         : 03 Aug 2022 12:43:22
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
PROGRAM DYNAMIC.ARRAY.1
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
    FRIEND.LIST="BOB BUILDER":@FM:"ARTIST":@FM:"123456":@FM:"MUSIC":@VM:"PAINTING":@FM:"INDIA":@SM:"TAJ MAHAL":@SM:"CHENNAI":@VM:"UK":@SM:"BIG BEN":@FM:"BLUE"
    FRIEND.LIST<4,-1>="BAKING"
    PRINT FRIEND.LIST<4>
    PRINT FRIEND.LIST<4,1>
    PRINT FRIEND.LIST<4,2>
    PRINT FRIEND.LIST<4,3>
    PRINT FRIEND.LIST<5,2,1>
    PRINT FRIEND.LIST<5,1,2>
    PRINT FRIEND.LIST<5,1,3>
END
