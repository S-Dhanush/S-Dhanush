* @ValidationCode : MjotMjM4NDg5NjU0OkNwMTI1MjoxNjU5MzQxMjc5ODYzOkRTMDA4NDM4NTY6LTE6LTE6MDowOmZhbHNlOk4vQTpSMjFfU1AxMy4wOi0xOi0x
* @ValidationInfo : Timestamp         : 01 Aug 2022 13:37:59
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
PROGRAM CASE.PROGRAM
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
    NAME = "DHANUSH"
    BEGIN CASE
        CASE NAME[2,3]="DHA"
            PRINT NAME
        CASE NAME[2,3]="ABC"
            PRINT NAME
        CASE NAME[2,3]="HAN"
            PRINT NAME
        CASE 1
            PRINT"NO MATCH FOUND"
    END CASE
END
END
