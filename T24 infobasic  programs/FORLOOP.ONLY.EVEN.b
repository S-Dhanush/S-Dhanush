* @ValidationCode : Mjo5ODkwMjMyMDk6Q3AxMjUyOjE2NTk0MTczODg2MzE6RFMwMDg0Mzg1NjotMTotMTowOjA6ZmFsc2U6Ti9BOlIyMV9TUDEzLjA6LTE6LTE=
* @ValidationInfo : Timestamp         : 02 Aug 2022 10:46:28
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
PROGRAM FORLOOP.ONLY.EVEN
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
    $INSERT I_COMMON
    $INSERT I_EQUATE
*-----------------------------------------------------------------------------
    FOR I=10 TO 1 STEP -1
        PRINT"COUNTER VARIABLE: ":I
    NEXT
END
END
