package cn.xzxunda.Repository;

import cn.xzxunda.domain.Sys_File;
import org.springframework.stereotype.Repository;

/**
 * Created by ThinkPad on 2017-10-30.
 */
public interface FileUploadRepository extends Repository {

    Sys_File saveAndFlush(Sys_File sys_file);

}
