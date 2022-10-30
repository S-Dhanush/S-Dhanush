* @ValidationCode : MjotMTExMDczODAyNDpDcDEyNTI6MTY1OTU5NDkzNTc2OTpEUzAwODQzODU2Oi0xOi0xOjA6MDpmYWxzZTpOL0E6UjIxX1NQMTMuMDotMTotMQ==
* @ValidationInfo : Timestamp         : 04 Aug 2022 12:05:35
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
PROGRAM FINDSTR.1
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
    FRIEND.LIST="BOB BUILDER":@FM:"ARTIST":@FM:"123456":@VM:"124680":@FM:"MUSIC":@VM:"PAINTING":@VM:"BAKING":@FM:"INDIA":@SM:"TAJ MAHAL":@SM:"CHENNAI":@VM:"UK":@SM:"BIG BEN":@FM:"BLUE"
    FRIEND.LIST<4,2,-1>="HORROR"
    FINDSTR "ART" IN FRIEND.LIST SETTING F1,F2,F3 THEN
        CRT"FOUND IN " :F1:" ":F2:" ":F3
    END
