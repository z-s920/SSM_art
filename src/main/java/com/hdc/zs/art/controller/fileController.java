package com.hdc.zs.art.controller;


import com.hdc.zs.art.service.CpeopleService;
import com.hdc.zs.art.service.PaintingService;
import com.hdc.zs.art.service.WpeoplesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class fileController {
@Autowired
private PaintingService paintingService;
@Autowired
private CpeopleService cpeopleService;
@Autowired
private WpeoplesService wpeoplesService;
    @PostMapping(value = "/upload")
    public <Exceptin extends Throwable> Object upload(@RequestParam("file") MultipartFile file,
                                                      @RequestParam("title") String name,
                                                      @RequestParam("desc") String des) throws UnsupportedEncodingException {
        try {
            if (file != null && !file.isEmpty()) {
                File directory = new File("");//设定为当前文件夹
                File destFile = new File(directory.getAbsolutePath()+"/src/main/resources/static/asserts/image/"+file.getOriginalFilename());
                System.out.println(destFile);
                if(!destFile.getParentFile().exists()){
                    destFile.getParentFile().mkdirs();//创建父级文件路径
                    destFile.createNewFile();//创建文件
                }
                DataOutputStream out = new DataOutputStream(new FileOutputStream(destFile));
                InputStream is = null;
                try {
                    is = file.getInputStream();
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    out.write(b);

                    // 执行插入操作

                    String img = "image/" + file.getOriginalFilename();
                    paintingService.upLoadPicture(name,img,des);
                    System.out.println(name + "----" + img + "----" + des);


                    // end

                    return "0";
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                }
            }

            return "成功";
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "失败";
    }



    @PostMapping(value = "/uploadChinese")
    public <Exceptin extends Throwable> Object uploadChinese(@RequestParam("file") MultipartFile file,
                                                      @RequestParam("paintsName") String paintsName,
                                                      @RequestParam("sellingPrice") Integer sellingPrice) throws UnsupportedEncodingException {
        try {
            if (file != null && !file.isEmpty()) {
                File directory = new File("");//设定为当前文件夹
                File destFile = new File(directory.getAbsolutePath()+"/src/main/resources/static/asserts/image/"+file.getOriginalFilename());
                System.out.println(destFile);
                if(!destFile.getParentFile().exists()){
                    destFile.getParentFile().mkdirs();//创建父级文件路径
                    destFile.createNewFile();//创建文件
                }
                DataOutputStream out = new DataOutputStream(new FileOutputStream(destFile));
                InputStream is = null;
                try {
                    is = file.getInputStream();
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    out.write(b);

                    // 执行插入操作

                    String paintsCoverImg = "asserts/image/" + file.getOriginalFilename();
                    int i = paintingService.upLoadChinesePicture(paintsName, paintsCoverImg, sellingPrice);
                    System.out.println(i);
                    System.out.println(paintsName + "----" + paintsCoverImg + "----" + sellingPrice);


                    // end

                    return "0";
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                }
            }

            return "成功";
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "失败";
    }




    @PostMapping(value = "/uploadWestern")
    public <Exceptin extends Throwable> Object uploadWestern(@RequestParam("file") MultipartFile file,
                                                             @RequestParam("paintsName") String paintsName,
                                                             @RequestParam("sellingPrice") Integer sellingPrice) throws UnsupportedEncodingException {
        try {
            if (file != null && !file.isEmpty()) {
                File directory = new File("");//设定为当前文件夹
                File destFile = new File(directory.getAbsolutePath()+"/src/main/resources/static/asserts/image/"+file.getOriginalFilename());
                System.out.println(destFile);
                if(!destFile.getParentFile().exists()){
                    destFile.getParentFile().mkdirs();//创建父级文件路径
                    destFile.createNewFile();//创建文件
                }
                DataOutputStream out = new DataOutputStream(new FileOutputStream(destFile));
                InputStream is = null;
                try {
                    is = file.getInputStream();
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    out.write(b);

                    // 执行插入操作

                    String paintsCoverImg = "asserts/image/" + file.getOriginalFilename();
                    paintingService.upLoadWesternPicture(paintsName,paintsCoverImg,sellingPrice);
                    System.out.println(paintsName + "----" + paintsCoverImg + "----" + sellingPrice);


                    // end

                    return "0";
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                }
            }

            return "成功";
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "失败";
    }



    @PostMapping(value = "/uploadChinesePeople")
    public <Exceptin extends Throwable> Object uploadChinesePeople(@RequestParam("file") MultipartFile file,
                                                             @RequestParam("paintsName") String paintsName) throws UnsupportedEncodingException {
        try {
            if (file != null && !file.isEmpty()) {
                File directory = new File("");//设定为当前文件夹
                File destFile = new File(directory.getAbsolutePath()+"/src/main/resources/static/asserts/image/"+file.getOriginalFilename());
                System.out.println(destFile);
                if(!destFile.getParentFile().exists()){
                    destFile.getParentFile().mkdirs();//创建父级文件路径
                    destFile.createNewFile();//创建文件
                }
                DataOutputStream out = new DataOutputStream(new FileOutputStream(destFile));
                InputStream is = null;
                try {
                    is = file.getInputStream();
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    out.write(b);

                    // 执行插入操作

                    String paintsCoverImg = "asserts/image/" + file.getOriginalFilename();
                    cpeopleService.upLoadChinesePeople(paintsName,paintsCoverImg);
                    System.out.println(paintsName + "----" + paintsCoverImg + "----" );


                    // end

                    return "0";
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                }
            }

            return "成功";
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "失败";
    }

    @PostMapping(value = "/uploadWesternPeople")
    public <Exceptin extends Throwable> Object uploadWesternPeople(@RequestParam("file") MultipartFile file,
                                                                   @RequestParam("paintsName") String paintsName
                                                                  ) throws UnsupportedEncodingException {
        try {
            if (file != null && !file.isEmpty()) {
                File directory = new File("");//设定为当前文件夹
                File destFile = new File(directory.getAbsolutePath()+"/src/main/resources/static/asserts/image/"+file.getOriginalFilename());
                System.out.println(destFile);
                if(!destFile.getParentFile().exists()){
                    destFile.getParentFile().mkdirs();//创建父级文件路径
                    destFile.createNewFile();//创建文件
                }
                DataOutputStream out = new DataOutputStream(new FileOutputStream(destFile));
                InputStream is = null;
                try {
                    is = file.getInputStream();
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    out.write(b);

                    // 执行插入操作

                    String paintsCoverImg = "asserts/image/" + file.getOriginalFilename();
                    wpeoplesService.upLoadWesternPeople(paintsName,paintsCoverImg);
                    System.out.println(paintsName + "----" + paintsCoverImg + "----" );


                    // end

                    return "0";
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                }
            }

            return "成功";
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "失败";
    }

}
