* @ValidationCode : MjotNTI4NTE5NjQ2OkNwMTI1MjoxNjU5NTkxOTA3NjY0OkRTMDA4NDM4NTY6LTE6LTE6MDowOmZhbHNlOk4vQTpSMjFfU1AxMy4wOi0xOi0x
* @ValidationInfo : Timestamp         : 04 Aug 2022 11:15:07
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
PROGRAM INS.1
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
    PRG = 100:@FM:200:@FM:300:@FM:400:@FM:500
    VALUES = ''
    FOR NATURAL.NUM = 1 TO 10
        INS NATURAL.NUM BEFORE PRG<3>
    NEXT NATURAL.NUM
    PRINT PRG
END
