(function(){

    var site ={
        // website: 'http://nenu_oa_front:88/', 
        // staticWebsite: 'http://nenu_oa_front:88/',
        // puiWebsite: 'http://pui.dev.net/1.1/'

        website: 'http://localhost:8080/',//站点地址
        staticWebsite: 'http://jysj.dsjyw.local.net/resources/', // 前端服务器地址
        puiWebsite: 'http://jysj.dsjyw.local.net/resources/pui/' //pui地址
    }

    _pw_env = {
        status: 0, //0-前端调试，1-后端调试, 2-后端部署
        website: site.website,
        staticWebsite: site.staticWebsite,
        puiWebsite: site.puiWebsite,
        tag: '',
        pkgs:[
            {
                name: 'io',
                path: site.staticWebsite + 'resources/js/'
            },
            {
                name: 'module',
                path: site.staticWebsite + 'resources/js/'
            },
            {
                name: 'widget',
                path: site.staticWebsite + 'resources/js/'
            },
            {
                name: 'page',
                path: site.staticWebsite + 'resources/js/'
            },
            {
                name: 'common',
                path: site.staticWebsite+'resources/js/page'
            }
        ],
        preload: ['sizzle'],//预加载模块
        //对pui各个组件的一个
        modSettings:{
            notifier: {
                top: 100
            },
            dialog:{
                //opacity: 0.5,//ie8下dialog显示不正常
                position: 'fixed',
                themeUrl: site.staticWebsite + 'resources/css/widget/core.css'
            },
            ztree:{
                themeUrl: site.staticWebsite + 'resources/css/widget/core.css'
            },
            defender:{
                themeUrl: site.staticWebsite + 'resources/css/widget/core.css'
            },
            scroll:{
                cursorborderradius: 0,
                cursorcolor: '#3d3d3d'
            },
            tooltip:{
                position: {
                    my: 'tc',
                    at: 'bc' //options: tl,tc,tr, rt,rc,rb, bl,bc,br,lt,lc,lb 
                },
                styles:{
                    uri: site.staticWebsite + 'resources/css/widget/core.css'
                }
            }
        },
        //统一错误信息
        msg:{
        },
        //统一路径位置
        url:{
            module:{
                company:{
                    getCompany:site.website+'data/ajax/company'
                },
                linkage:{
                    getCity:site.website+'company/ajax/companyPlace/query',
                    // getCityEmp:site.website+'/test/api-data/002.json',
                    // getMajor:site.website+'/test/api-data/033.json'
                    getCityEmp:site.website+'data/ajax/place/query',
                    getMajor:site.website+'data/ajax/major/query'
                },
                select:{
                    getOption:site.website+'recruit/ajax/getSelectList'
                    // getOption:site.website+'test/api-data/005.json'
                }
            },
            recruit:{
                need:{
                    add:site.website+'recruit/jobRequest/ajax/add',
                    del:site.website+'recruit/jobRequest/ajax'
                },
                visitor:{
                    add:site.website+'recruit/view/ajax/add',
                    del:site.website+'recruit/view/ajax',
                    getContact:site.website+'contact/ajax/telphone',
                    getLeader:site.website+'contact/ajax/grade'
                },
                recruit:{
                    valid:site.website+'recruit/ajax/timePlaceConflict',
                    delBatch:site.website+'recruit/ajax/del',
                    enter:site.website+'recruit/enter'
                },
                interview:{
                    valid:site.website+'recruit/interview/ajax/timePlaceConflict',
                    del:site.website+'recruit/ajax/'
                },
                written:{
                    valid:site.website+'recruit/written/ajax/timePlaceConflict',
                    del:site.website+'recruit/ajax/'
                },
                lecture:{
                    load:site.website+'recruit/lecture/ajax/graph',
                    add:site.website+'recruit/lecture/ajax/saveAmbassador',
                    // addVisitor:site.website+'/test/api-data/030.json',
                    // editVisitor:site.website+'/test/api-data/030.json',
                    // delVisitor:site.website+'/test/api-data/030.json'
                    addVisitor:site.website+'recruit/ajax/visitor/add',
                    editVisitor:site.website+'recruit/ajax/visitor/update',
                    delVisitor:site.website+'recruit/ajax/visitor'
                },
                space:{
                    load:site.website+'recruit/space/ajax/graph'
                }
            },
            banquet:{
                select:{
                    attendee:site.website+'feast/ajax/getPersonList',
                    contact:site.website+'feast/ajax/getPersonList',
                    getUser:site.website+'feast/getQuickFeastLeader'
                },
                feast:{
                    communication:site.website+'/test/api-data/031.json'
                }
            },
            company:{
                companyInfo:{
                    addConnecter:site.website+'contact/ajax/add',
                    delConnecter:site.website+'contact/ajax',
                    delBatch:site.website+'company/ajax/del'
                },
                contact:{
                    add:site.website+'contact/ajax/add',
                    del:site.website+'contact/ajax/del',
                    mod:site.website+'contact/ajax/update',
                    getContact:site.website+'contact/ajax/update'
                }
            },
            reception:{
                vehicle:{
                    delBatch:site.website+'reception/ajax/car/batchdel'
                },
                hotel:{
                    delBatch:site.website+'reception/ajax/hotel/batchdel'
                }
            },
            system:{
                user:{
                    lock:site.website+'user/lock',
                    unlock:site.website+'user/unlock',
                    delBatch:site.website+'user/del',
                    addValid:site.website+'user/add/isExist',
                    modValid:site.website+'user/update/isExist'
                },
                place:{
                    del:site.website+'place/ajax/del',
                    nameValid:site.website+'place/add/isExist'
                }
            },
            Index:{
                getInfo:site.website+'index/ajax/time',
                getLectureDate:site.website+'recruit/index/getRecruitDateInMonth',
                //getLectureDate:site.website+'test/api-data/028.json'
                message:{
                    del:site.website+'message/ajax/delete',
                    handle:site.website+'message/ajax/handle',
                    // get:site.website+'test/api-data/005.json',
                    get:site.website+'user/role/list',
                    send:site.website+'message/insert/batch'
                }
            },
            //地址信息
          

                // 学生页面
               employment:{

                    // 填写学籍信息页面

                        write_info:{
                            majorMinorClass: site.staticWebsite + 'mock/majorMinorClass.json',
                            majorName: site.staticWebsite + 'mock/majorName.json',
                            getCity: site.staticWebsite + 'mock/getCity.json',
                            getArea: site.staticWebsite + 'mock/getArea.json',
                        }
                    } ,


            employment: {
                student: {
                    add: site.website+'test/api-data/005.json',
                    del: site.website+'data/del/',
                    /*生源结构*/
                    searchStruct: site.website+'data/queryStudentStructure',
                    searchOrderbyStruct: site.website+'data/queryStudentStructure',
                    /*就业率*/
                    searchRate: site.website+'data/queryEmploymentRate',
                    searchOrderbyRate: site.website+'data/queryEmploymentRate',
                    /*拟就业率*/
                    searchRateNi: site.website+'data/queryPlanEmploymentRate',
                    searchOrderbyRateNi: site.website+'data/queryPlanEmploymentRate',
                    /*就业结构*/
                    searchStructEmp: site.website+'data/queryEmploymentStructure',
                    searchOrderbyStructEmp: site.website+'data/queryEmploymentStructure'
                }
            },
            // 学生页面
            student_page:{
                /*qiyuan*/
                // 填写学籍信息页
                write_info:{
                    write_info:{
                        majorMinorClass: site.staticWebsite + 'mock/majorMinorClass.json',
                        majorName: site.staticWebsite + 'mock/majorName.json',
                        getCity: site.staticWebsite + 'mock/getCity.json',
                        getArea: site.staticWebsite + 'mock/getArea.json'
                    }
                },
                /*chenyongzhen*/
                // 修改学籍信息页
                alter_info:{
                    alterInfo:{
                        getCity:site.staticWebsite+'mock/city.json',
                        getTown:site.staticWebsite+'mock/town.json',
                        getMMajor:site.staticWebsite+'mock/MMajor.json',
                        getSMajor:site.staticWebsite+'mock/SMajor.json'
                    }
                },
                /*xieyiting*/
                // 查看学籍信息
                look_info:{
                    look_info:{
                        isNameRegistered:site.staticWebsite+'mock/isNameRegistered.json'
                    }
                },
                // 修改密码
                alter_password:{
                    alter_password:{
                        isModifySuc:site.staticWebsite+'mock/isModifySuc.json'
                    }
                }

            },

            // 学院页面
            college_page:{
                /*liaoyueyun*/
                // 新增学生
                // new_student:{
                //     new_student:{
                //         isAccountRegistered:site.staticWebsite+'mock/isAccountRegistered.json',
                //         isAddNewStudent:site.website+'mock/isAddNewStudent.json'
                //     }
                // },
                new_student:{
                    new_student:{
                        isAccountRegistered:site.staticWebsite+'mock/isAccountRegistered.json',
                        isAddNewStudent:site.website+'college_page/queryStudentStructure'
                    }
                },
                detail:{
                    detail:{
                        collegeShowMaterial:site.staticWebsite+'mock/collegeShowMaterial.json'
                    }
                },
                new_student:{
                    new_student:{
                        isAccountRegistered:site.staticWebsite+'mock/isAccountRegistered.json',
                        isAddNewStudent:site.staticWebsite+'mock/isAddNewStudent.json'
                    }
                },
                /*lixingyu*/
                // 学生列表
                students_list: {
                    students_list: {
                        showStu: site.website + 'college_page/students_list/ajax/students_list'
                    }
                },

                // 学籍信息详情
                detail:{
                    detail:{
                        collegeShowMaterial:site.staticWebsite+'mock/collegeShowMaterial.json'
                    }
                },
                /*lixingyu*/
                // 学生列表
                students_list: {
                    students_list: {
                        showStu: site.staticWebsite + 'mock/stuInfo.json'
                    }
                }
            },
            // 学校页面
            school_page:{
                /*zhangmeiyun*/
                // 学生列表
                students_list:{
                    students_list:{
                        showStudentInfo:site.staticWebsite+'mock/showStudentInfo.json'
                    }
                },
                detail:{
                    detail:{
                        schoolShowMaterial:site.staticWebsite+'mock/schoolShowMaterial.json'
                    }
                }
        },
            //地址信息
            url:{
                student_page:{
                    look_info:{
                        look_info:{
                            isisPicName:site.staticWebsite+'mock/isPicName.json'
                        }
                    },
                    alter_password:{
                        alter_password:{
                            isModifySuc:site.staticWebsite+'mock/isModifySuc.json',
                            isNewPassword:site.staticWebsite+'mock/isNewPassword.json'

                        }
                    }
                }
            }
        }
    }
})()