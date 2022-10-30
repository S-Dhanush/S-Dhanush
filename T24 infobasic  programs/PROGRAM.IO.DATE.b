* @ValidationCode : Mjo4ODYxMzIzMzQ6Q3AxMjUyOjE2NTk2MDA1NTAzMzI6RFMwMDg0Mzg1NjotMTotMTowOjA6ZmFsc2U6Ti9BOlIyMV9TUDEzLjA6LTE6LTE=
* @ValidationInfo : Timestamp         : 04 Aug 2022 13:39:10
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
PROGRAM PROGRAM.IO.DATE
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
* DEBUG
    $INSERT I_COMMON
    $INSERT I_EQUATE
    XX = "12 SEP 1998"
    C = ICONV(XX,"D")
 
    PRINT C
    W = OCONV(C,"D4/")
    PRINT W
    K = OCONV(C,"D2/")
    PRINT K
    PRINT 'TODAY DATE IS: ' :TODAY
 
END
