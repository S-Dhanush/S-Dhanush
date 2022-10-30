* @ValidationCode : Mjo2MTg2MjAxODM6Q3AxMjUyOjE2NTk1OTk3Mjg4NTk6RFMwMDg0Mzg1NjotMTotMTowOjA6ZmFsc2U6Ti9BOlIyMV9TUDEzLjA6LTE6LTE=
* @ValidationInfo : Timestamp         : 04 Aug 2022 13:25:28
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
PROGRAM LOCATE.2
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
    FRIEND.LIST="BOB BUILDER":@FM:"ARTIST":@FM:"123456":@VM:"124680":@FM:"MUSIC":@VM:"PAINTING":@VM:"BAKING":@FM:"INDIA":@SM:"TAJ MAHAL":@SM:"CHENNAI":@VM:"UK":@SM:"BIG BEN":@SM"LONDON":@FM:"BLUE"
    FRIEND.LIST<4,2,-1>="HORROR"
    SEARCHSTR="UK"
    LOCATE SEARCHSTR IN FRIEND.LIST<5,1> SETTING DHA ELSE NULL
    PRINT DHA
END
