* @ValidationCode : MjotMTYzMTM4NDE1MDpDcDEyNTI6MTY1OTUwMjY1MDg4NDpEUzAwODQzODU2Oi0xOi0xOjA6MDpmYWxzZTpOL0E6UjIxX1NQMTMuMDotMTotMQ==
* @ValidationInfo : Timestamp         : 03 Aug 2022 10:27:30
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
PROGRAM ARRAY.1
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
    DIM ARRAY(5)
    QTY=10
    MAT ARRAY=QTY
    FOR X=1 TO 5
        PRINT"ARRAY(":X:")=",ARRAY(X)
    NEXT X
END
