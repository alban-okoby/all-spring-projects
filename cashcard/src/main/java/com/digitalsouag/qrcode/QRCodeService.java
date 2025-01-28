package com.digitalsouag.qrcode;

import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

public interface QRCodeService {
    BufferedImage generateQRCodeImage(String text) throws Exception;
}
