* @ValidationCode : MjotMTc3NDc3NDc1OkNwMTI1MjoxNjU5NTk3OTUwNDY2OkRTMDA4NDM4NTY6LTE6LTE6MDowOmZhbHNlOk4vQTpSMjFfU1AxMy4wOi0xOi0x
* @ValidationInfo : Timestamp         : 04 Aug 2022 12:55:50
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
PROGRAM LOCATE.1
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
    FRIEND.LIST="BOB BUILDER":@FM:"ARTIST":@FM:"123456":@VM:"124680":@FM:"MUSIC":@VM:"PAINTING":@VM:"BAKING":@FM:"INDIA":@SM:"TAJ MAHAL":@SM:"CHENNAI":@VM:"UK":@SM:"BIG BEN":@FM:"BLUE"
    FRIEND.LIST<4,2,-1>="HORROR"
    SEARCHSTR="124680"
    LOCATE SEARCHSTR IN FRIEND.LIST<3,1> SETTING MVPOS ELSE NULL
    PRINT MVPOS
END
