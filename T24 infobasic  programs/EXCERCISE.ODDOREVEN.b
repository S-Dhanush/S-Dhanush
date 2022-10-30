* @ValidationCode : MjoxMjAzMjU1NjMyOkNwMTI1MjoxNjU5NDE2NjU1MjY0OkRTMDA4NDM4NTY6LTE6LTE6MDowOmZhbHNlOk4vQTpSMjFfU1AxMy4wOi0xOi0x
* @ValidationInfo : Timestamp         : 02 Aug 2022 10:34:15
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
PROGRAM EXCERCISE.ODDOREVEN
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------
    $INSERT I_COMMON
    $INSERT I_EQUATE
*-----------------------------------------------------------------------------
    CRT"ENTER THE NUMBER YOU WANT TO CHECK"
    INPUT K
    J= MOD(K,2)
    IF J=0 THEN
        PRINT"IT IS EVEN NUMBER : " :K
    END ELSE
        PRINT"IT IS ODD NUMBER : ":K
    END

END
