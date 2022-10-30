* @ValidationCode : Mjo4OTIyNjg1NTpDcDEyNTI6MTY1OTQxNTI4ODg3NzpEUzAwODQzODU2Oi0xOi0xOjA6MDpmYWxzZTpOL0E6UjIxX1NQMTMuMDotMTotMQ==
* @ValidationInfo : Timestamp         : 02 Aug 2022 10:11:28
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
PROGRAM FORLOOP.2
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------
    $INSERT I_COMMON
    $INSERT I_EQUATE
*-----------------------------------------------------------------------------
    CRT"ENTER THE NUMBER OF TIMES U WANT TO PRINT"
    INPUT J
    FOR I=1 TO J
        PRINT" COUNTER VARIABLE: " :I
    NEXT
END
