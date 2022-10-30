* @ValidationCode : MjoxNzE5NzI1MDc2OkNwMTI1MjoxNjU5NTkzMzU5ODk1OkRTMDA4NDM4NTY6LTE6LTE6MDowOmZhbHNlOk4vQTpSMjFfU1AxMy4wOi0xOi0x
* @ValidationInfo : Timestamp         : 04 Aug 2022 11:39:19
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
PROGRAM INS.2
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
    FRIEND.LIST="BOB BUILDER":@FM:"ARTIST":@FM:"123456":@VM:"124680":@FM:"MUSIC":@VM:"PAINTING":@VM:"BAKING":@FM:"INDIA":@SM:"TAJ MAHAL":@SM:"CHENNAI":@VM:"UK":@SM:"BIG BEN":@FM:"BLUE"
    FRIEND.LIST<4,2,-1>="HORROR"
    INS "ART" BEFORE FRIEND.LIST<4,2>
    PRINT FRIEND.LIST
    PRINT FRIEND.LIST<4,2>
END
